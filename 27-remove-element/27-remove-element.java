class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int l = 0, r = 0;
        while(r < nums.length){
            if(nums[r] == val){
                r++;
                continue;
            }
            
            nums[l++] = nums[r++];
        }
        return l;
    }
}