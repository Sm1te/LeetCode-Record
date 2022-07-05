class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int count = p.length();
        List<Integer> res = new ArrayList();
        int[] map = new int[128];
        for(char c : p.toCharArray())
            map[c]++;
        
        int left = 0, right = 0;
        while(right < s.length()){
            char rightChar = s.charAt(right);
            if(map[rightChar] > 0){
                count--;
            }
            map[rightChar]--;
            right++;
            
            while(count == 0){
                char leftChar = s.charAt(left);
                map[leftChar]++;
                if(map[leftChar] > 0){
                    count++;
                    if(right - left == p.length())
                        res.add(left);
                }
                left++;
            }
            
        }
        
        return res;
    }
}