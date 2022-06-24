class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //构建dp数组
        int n = matrix.length;
        int[][] dp = new int[n][n];

        //第一排的没有参照物，直接拿matrix的值
        for(int j = 0; j < n; j++)
            dp[0][j] = matrix[0][j];
        
        //除了最左和最右只需要对比两个，其余的都要比较三个中的最小值
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + matrix[i][0];
            dp[i][n - 1] = Math.min(dp[i - 1][n - 1], dp[i - 1][n - 2]) + matrix[i][n - 1];
            for(int j = 1; j < n - 1; j++){
                dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1], dp[i - 1][j + 1]) + matrix[i][j];
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            res = Math.min(dp[n - 1][j], res);
        }

        return res;
    }

    
    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}