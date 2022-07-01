class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        int t0_0 = 0;
        int t0_1 = -prices[0];
        
        for(int i = 1; i < prices.length; i++){
            t0_0 = Math.max(t0_0, t0_1 + prices[i]);
            t0_1 = Math.max(t0_1, -prices[i]);
        }
        
        return t0_0;
    }
}