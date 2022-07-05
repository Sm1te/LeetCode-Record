class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int area = 0;
        while(left < right){
            int tmp = (right - left) * Math.min(height[left], height[right]);
            area = Math.max(area, tmp);
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return area;
    }
}