class Solution {
    public int largestVariance(String s) {
        int res = 0;

        for(char i = 'a'; i <= 'z'; i++){
            for(char j = 'a'; j <= 'z'; j++){
                if(i == j)
                    continue;
                
                int diff = 0;
                int diffB = -s.length();
                for(int z = 0; z < s.length(); z++){
                    if(s.charAt(z) == i){
                        diff++;
                        diffB++;
                    }else if(s.charAt(z) == j){
                        diffB = --diff;
                        diff = Math.max(diff, 0);
                    }
                    res = Math.max(res, diffB);
                }
            }
        }
        return res;
    }
}