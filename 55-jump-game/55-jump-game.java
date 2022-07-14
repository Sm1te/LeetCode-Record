class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMost = nums[0];
        
        for(int i = 0; i < n; i++){
            if(i <= rightMost){
                rightMost = Math.max(rightMost, i + nums[i]);
                if(rightMost >= n - 1)
                    return true;
            }
        }
        return false;
    }
}