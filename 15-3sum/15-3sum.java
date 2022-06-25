class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if(nums.length < 3)
            return res;

        Arrays.sort(nums);
        
        int n = nums.length;
        for(int i = 0; i < n; i++){
            //这部分是可以直接判断的
            if(nums[i] > 0)
                return res;
            
            //对i查重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = n - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                
                if(sum < 0){
                    left++;
                }else if(sum > 0){
                    right--;
                }else{
                    res.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
                    while(left < right && nums[left] == nums[left + 1])
                        left++;
                    while(left < right && nums[right] == nums[right - 1])
                        right--;
                    
                    left++;
                    right--;
                }
            }
        }
        
        return res;
    }
}