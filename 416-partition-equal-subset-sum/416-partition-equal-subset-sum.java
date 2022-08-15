class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums)
            sum += i;
        if(sum % 2 == 1)
            return false;
        
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for(int i = 0; i <= nums.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i <= nums.length; i++){
            for(int j = 1; j <= target; j++){
                if (j - nums[i - 1] < 0) {
                    // 背包容量不足，不能装入第 i 个物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 装入或不装入背包
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
            
        }

        return dp[nums.length][target];
    }
}