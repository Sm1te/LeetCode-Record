class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1)
            return nums[0] == target ? 0 : -1;
        
        int edge = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i - 1]){
                edge = i;
            }
        }
        
        int left = BinarySearch(nums, 0, edge - 1, target);
        int right = BinarySearch(nums, edge, nums.length - 1, target);
        if(left == -1 && right == -1){
            return -1;
        }else if(right == -1){
            return left;
        }
        
        return right;
    }
    
    public static int BinarySearch(int[] nums, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid - 1;
            else 
                return mid;
        }
        return -1;
    }
}