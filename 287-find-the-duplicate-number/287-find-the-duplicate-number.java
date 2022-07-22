class Solution {
    public int findDuplicate(int[] nums) {
        int l =  -1, r = nums.length;
        
        while(l + 1 != r){
            int mid = l + (r - l) / 2;
            int count = 0;
            for(int num : nums)
                if(num <= mid)
                    count++;
            
            if(count > mid)
                r = mid;
            else
                l = mid;
        }
        return r;
    }
}