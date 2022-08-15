class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for(char a : magazine.toCharArray())
            map[a - 'a']++;

        for(char b : ransomNote.toCharArray()){
            map[b - 'a']--;
            if(map[b - 'a'] < 0)
                return false;
        }

        return true;
    }
}