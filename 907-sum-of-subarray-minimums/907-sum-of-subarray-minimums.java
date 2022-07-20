class Solution {
    public int sumSubarrayMins(int[] nums) {
        Deque<int[]> deq = new ArrayDeque<>();
        int n = nums.length;
        
        if(n == 1)
            return nums[0];
        
        long res = 0;
        int[] left = new int[n];
        int[] right = new int[n];

        //obtain the left part
        for(int i = 0; i < n; i++){
            while(!deq.isEmpty() && deq.peek()[0] >= nums[i])
                deq.pop();
            // actually here is i - (-1)
            left[i] = deq.isEmpty() ? i + 1 : i - deq.peek()[1];
            deq.push(new int[]{nums[i], i});
        }
        
        deq.clear();
        
        //obtain the right part
        for(int i = n - 1; i >= 0; i--){
            while(!deq.isEmpty() && deq.peek()[0] > nums[i])
                deq.pop();
            
            right[i] = deq.isEmpty() ? n - i : deq.peek()[1] - i;
            deq.push(new int[]{nums[i], i});
        }
        
        long mod = 1000000007;
        
        for(int i = 0; i < n; i++){
            res += (long) (left[i] * right[i]) % mod * nums[i] % mod;
            res %= mod;
        }
        
        return (int) res;
    }
}