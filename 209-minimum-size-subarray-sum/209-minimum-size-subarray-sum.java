class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        while(r < nums.length){
            sum += nums[r];
            if(sum < target){
                r++;
            }else{
                while(sum >= target){
                    res = Math.min(r - l + 1, res);
                    sum -= nums[l++];
                }
                r++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}