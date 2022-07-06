class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
       
        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(i - coin < 0)
                    continue;
                
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == 10001 ? -1 : dp[amount];
    }
}