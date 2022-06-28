class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 1)
            return 0;
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(coin <= i){
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
    
}