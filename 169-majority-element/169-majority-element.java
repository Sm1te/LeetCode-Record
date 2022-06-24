class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        
        Arrays.sort(nums);
        int count = 1;
        for(int i = 1; i < n; i++){
            while(i < n && nums[i] == nums[i - 1]){
                count++;
                i++;
            }
            if(count > n / 2)
                return nums[i - 1];
        }
        return -1;
    }
}