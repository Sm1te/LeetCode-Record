class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[128];
        if(t.length() != s.length())
            return false;
        
        for(char c : s.toCharArray())
            map[c]++;
        
        for(char c : t.toCharArray()){
            map[c]--;
            if(map[c] < 0)
                return false;
        }
        
        return true;
    }
}