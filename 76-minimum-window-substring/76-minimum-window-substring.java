class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            map[c]++;
        }
        String res = "";
        int min = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int count = t.length();
        while(right < s.length()){
            char cRight = s.charAt(right);
            
            if(map[cRight] > 0){
                count--;
            }
            
            map[cRight]--;
            right++;
            
            while(count == 0){
                if(right - left < min){
                    min = right - left;
                    res = s.substring(left, right);
                }
                char cLeft = s.charAt(left);
                map[cLeft]++;
                left++;
                if(map[cLeft] > 0)
                    count++;
            }  
        }
        return res;
    }
}