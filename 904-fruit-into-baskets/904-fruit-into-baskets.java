class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length == 1)
            return 1;

        int[] map = new int[fruits.length + 1];
        int l = 0, r = 0;
        int res = 0;
        int count = 0;
        while(r < fruits.length){
            if(map[fruits[r]] == 0){
                count++;
            }
            map[fruits[r]]++;
            while(count > 2){
                if(map[fruits[l]] == 1)
                    count--;
                map[fruits[l]]--;
                l++;
            }
            res = Math.max(r - l + 1, res);
            r++;
        }
        return res;
    }
}