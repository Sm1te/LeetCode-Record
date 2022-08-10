class Solution {
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length -1;
        int temp = 0;
        
        int[] result = new int[length];
        while(left<=right){
            if(nums[left]*nums[left] <= nums[right]*nums[right]){
                result[--length] = nums[right]*nums[right];
                right--;
            }else{
                result[--length] = nums[left]*nums[left];
                left++;
            }
        }
        return result;
    }

}