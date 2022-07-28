class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int res = -1;
        Arrays.sort(nums);
        int index = binaryS(nums, k);
        for(int i = 0; i <= index; i++){
            for(int j = index; j > i; j--){
                if(nums[j] + nums[i] < k){
                    res = Math.max(res, nums[j] + nums[i]);
                    break;
                }
            }
        }
        return res;
    }
    
    public int binaryS(int[] nums, int k){
        int l = -1, r = nums.length;
        while(l + 1 != r){
            int mid = l + (r - l) / 2;
            if(nums[mid] > k){
                r = mid;
            }else{
                l = mid;
            }
        }
        return l == - 1 ? 0 : l;
    }
}