class Solution {
    public int[] productExceptSelf(int[] nums) {
        int sum = 1;
        int zeros = 0;
        int[] res = new int[nums.length];
        for(int num : nums){
            if(num == 0){
                zeros++;
            }else{  
                sum *= num;
            }
            
            if(zeros > 1){
                Arrays.fill(res, 0);
                return res;
            }
            
        }
        
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                if(zeros > 0)
                    res[i] = 0;
                else
                    res[i] = sum / nums[i];
            }else{
                res[i] = sum;
            }
        }
        
        return res;
    }
}