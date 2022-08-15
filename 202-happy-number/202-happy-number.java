class Solution {
    public boolean isHappy(int n) {
        int sum = 0;
        Set<Integer> map = new HashSet();
        while(n != 1){
            while(n != 0){
                int tmp = n % 10;
                n /= 10;
                sum += (tmp * tmp);
            }
            if(map.contains(sum))
                return false;
            map.add(sum);
            if(sum == 1)
                return true;

            n = sum;
            sum = 0;
        }
        return true;
    }
}