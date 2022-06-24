class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m + 1][n + 1];
    
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] < 0 ? -dungeon[m - 1][n - 1] + 1 : 1;
        
        for(int i = m; i >= 0; i--){
            for(int j = n; j >= 0; j--){
                if( i == m || j == n){
                    dp[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                
                if (i == m - 1 && j == n - 1)
                    continue;
                
                int res = dungeon[i][j] - Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = res >= 0 ? 1 : -res;
            }
        }
        return dp[0][0];
    }
}