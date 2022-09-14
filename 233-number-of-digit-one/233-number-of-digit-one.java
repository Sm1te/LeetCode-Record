class Solution {
    public int countDigitOne(int n) {
        long multK = 1;
        int res = 0;
        for (int k = 0; n >= multK; ++k) {
            res += (n / (multK *10)) * multK + Math.min(Math.max(n % (multK * 10) - multK + 1, 0), multK);
            multK *= 10;
        }
        return res;
    }
}