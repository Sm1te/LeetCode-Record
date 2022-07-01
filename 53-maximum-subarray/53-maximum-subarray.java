class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int prev = 0;
        for(int x : nums){
            prev = Math.max(x, prev + x);
            res = Math.max(res, prev);
        }
        return res;
    }
}