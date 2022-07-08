class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        while(lo < hi){
            int mid = (hi + lo) >> 1;
            if(arr[mid] > arr[mid + 1]){
                hi = mid;
            }else
                lo = mid + 1;
        }
        return lo;
    }
}