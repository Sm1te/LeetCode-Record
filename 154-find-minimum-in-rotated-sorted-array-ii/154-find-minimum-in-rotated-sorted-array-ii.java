class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi){
            int mid = (hi + lo) >> 1;
            if(nums[mid] < nums[hi]){
                hi = mid;
            }else if(nums[mid] > nums[hi]){
                lo = mid + 1;
            }else{
                hi--;
            }
        }
        
        return nums[lo];
    }
}