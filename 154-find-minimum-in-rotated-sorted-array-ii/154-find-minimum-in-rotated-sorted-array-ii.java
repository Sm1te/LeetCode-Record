class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        
        int first = nums[0];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < first){
                index = i;
                break;
            }  
            first = nums[i];
        }
        
        return Math.min(nums[index], nums[0]);
    }
}