class Solution {
    public boolean search(int[] nums, int target) {
        int prev = nums[0];
        if(nums.length == 1)
            return nums[0] == target;
        
        int index = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < prev){
                index = i;
                break;
            }
            prev = nums[i];
        }
        
        if(index == 0){
            return BinarySearch(0, nums.length - 1, nums,target);
        }
        boolean l = BinarySearch(0, index - 1, nums,target);
        boolean r = BinarySearch(index, nums.length - 1, nums, target);
        return l || r;
    }
    
    public boolean BinarySearch(int left, int right, int[] nums, int target){
        if(nums == null || nums.length == 0)
            return false;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] > target)
                right = mid - 1;
            else if(nums[mid] < target)
                left = mid + 1;
            else
                return true;
        }
        return false;
    }
}