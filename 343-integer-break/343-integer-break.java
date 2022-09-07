class Solution {
    public int integerBreak(int n) {
        int mod = n % 3;
        int count = n / 3;
        if(mod == 0){
            if(count == 1)
                return 2;
            return (int)Math.pow(3, count);
        }else if(mod == 1){
            return (int)Math.pow(3, count - 1) * 4;
        }else if(mod == 2){
            if(count == 0)
                return 1;
            return (int)Math.pow(3, count) * 2;
        }
        return -1;
    }
}