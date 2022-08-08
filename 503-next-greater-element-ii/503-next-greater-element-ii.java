class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // 这里放元素索引，而不是元素
        Deque<Integer> s = new ArrayDeque<>(); 
        /* 单调栈模板 */
        for (int i = 2 * (n - 1) ; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i % n]) {
                s.pop();
            }
            // 得到索引间距
            res[i % n] = s.isEmpty() ? -1 : s.peek(); 
            // 将索引入栈，而不是元素
            s.push(nums[i % n]); 
        }
        return res;
    }
}