class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        int begin = 0, end = 0;
        int sum = 0;
        while(end < nums.length){
            sum += nums[end++];
            while(sum >= target){
                len = Math.min(len, end - begin);
                sum -= nums[begin++];
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}