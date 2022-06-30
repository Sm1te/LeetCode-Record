class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        if(n == 0 || n == 1)
            return 0;
        
        int[] prev = new int[n];
        int[] next = new int[n];
        int[] dp = new int[n];
        
        prev[0] = height[0];
        for(int i = 1; i < n; i++){
            prev[i] = Math.max(height[i], prev[i - 1]);
        }
        
        next[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--){
            next[i] = Math.max(height[i], next[i + 1]);
        }
        
        int res = 0;
        for(int i = 0; i < n; i++){
            res += Math.min(prev[i], next[i]) - height[i];
        }
        
        return res;
    }
}