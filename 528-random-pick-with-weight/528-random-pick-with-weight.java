class Solution {
    // 前缀和数组
    private int[] preSum;
    private Random rand = new Random();
    public Solution(int[] w) {
        int n = w.length;
        preSum = new int[n + 1];
        for(int i = 0; i < n; i++){
            preSum[i + 1] = preSum[i] + w[i];
        }
    }
    
    public int pickIndex() {
        int n = preSum.length;
        // 在闭区间 [0, preSum[n - 1]] 中随机选择一个数字
        int target = rand.nextInt(preSum[n - 1]);
        // 获取 target 在前缀和数组 preSum 中的索引
        // 别忘了前缀和数组 preSum 和原始数组 w 有一位索引偏移
        return left_bound(preSum, target) - 1;
    }

    public int left_bound(int[] preSum, int target){
        int l = -1, r = preSum.length;
        while(l + 1 != r){
            int mid = l + (r - l + 1) / 2;
            if(preSum[mid] > target){
                r = mid;
            }else{
                l = mid;
            }
        }
        return r;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */