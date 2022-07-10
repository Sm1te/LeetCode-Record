class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        
        int m = nums1.length;
        int n = nums2.length;
        
        int l = 0, r = m;
        // 分割线左边的所有元素需要满足的个数 m + (n - m + 1) / 2;
        // +1 向上取整避免 left + 1 = right 时可能无法继续缩小区间而陷入死循环
        int totalLeft = (m + n + 1) / 2;

        while(l < r){
            int i = l + (r - l + 1) / 2;
            int j = totalLeft - i;
            
             //要找最大i，使得nums1[i-1] <= nums2[j]
            //使用对立面缩小区间
            if (nums1[i - 1] > nums2[j]) {
                // [i+1, m]均不满足
                r = i - 1;
            } else {
                // i满足说明[0, i-1]均不为满足条件的最大i，舍去以缩小区间
                l= i;
            }
            
        }
        //退出循环时left=right，表示最终nums1中分割线的位置
        int i = l;
        //nums2中分割线的位置
        int j = totalLeft - l;
        
        //判断极端情况
        int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];  //nums1分割线左边没有元素
        int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];  //nums2分割线左边没有元素
        int nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];     //nums1分割线右边没有元素
        int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];     //nums2分割线右边没有元素
        
        if ((m + n) % 2 == 0) {
            return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
        } else {
            return Math.max(nums1LeftMax, nums2LeftMax);
        }

    }
}