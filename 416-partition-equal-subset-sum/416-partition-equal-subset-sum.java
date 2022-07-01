class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0)
            return false;
        
        int n = nums.length;
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        
        for(int i = 0; i <= n; i++)
            dp[i][0] = true;
        
        // for(int j = 0; j <= sum; j++)
        //     dp[nums.length][j] = false;
        
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j <= target; j++){
                if(j < nums[i])
                    dp[i][j] = dp[i + 1][j];
                else
                    dp[i][j] = dp[i + 1][j - nums[i]] || dp[i + 1][j];
            }
        }
        return dp[0][target];
    }
}