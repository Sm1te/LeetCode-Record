class Solution {
    public int mySqrt(int x) {
        long l = 0;
        long r = (long)x + 1;
        while(l + 1 != r) {
            long mid = (l + r) >> 1;
            if(mid * mid <= x) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return (int)l;
    }
}