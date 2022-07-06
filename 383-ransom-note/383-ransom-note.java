class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        
        for(char c: magazine.toCharArray()){
            int index = c - 'a';
            map[index]++;
        }
        
        for(char c: ransomNote.toCharArray()){
            int index = c - 'a';
            map[index]--;
            if(map[index] < 0) return false;
        }
        return true;
    }
}