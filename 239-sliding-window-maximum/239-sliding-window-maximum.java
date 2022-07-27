class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        
        Deque<Integer> deq = new ArrayDeque();
        int index = 0;
        for(int i = 0; i < n; i++){
            while(!deq.isEmpty() && nums[deq.peekLast()] < nums[i])
                deq.pollLast();
            
            deq.addLast(i);
            
            while(!deq.isEmpty() && Math.abs(deq.peekFirst() - i) + 1 > k)
                deq.pollFirst();
            
            if(i >= k - 1){
                res[index++] = nums[deq.peekFirst()];
            }
        }
        return res;
    }
}