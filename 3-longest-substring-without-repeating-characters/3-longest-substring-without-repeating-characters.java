class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        
        int[] map = new int[128];
        int res = 0, left = 0, right = 0, n = s.length();
        while(right < n){
            char tmp = s.charAt(right);
            map[tmp]++;
            if(map[tmp] > 1){
                while(s.charAt(left) != tmp){
                    map[s.charAt(left++)]--;
                }
                map[tmp]--;
                left++;
            }
            
            res = Math.max(right - left + 1, res);
            right++;
        }
        return res;
    }
}