class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        while(r < n){
            if(nums[r] == 0){
                r++;
                continue;
            }
            
            nums[l++] = nums[r++];
        }
        while(l < n)
            nums[l++] = 0;
    }
}