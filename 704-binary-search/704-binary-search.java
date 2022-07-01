class Solution {
    public int search(int[] nums, int target) {
        int l = -1, r = nums.length;
        while (l + 1 != r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid;
            } 
        }
        if (l == -1 || nums[l] != target) { // 越界或者不相等
            return -1;
        }
        return l;
    }
}
