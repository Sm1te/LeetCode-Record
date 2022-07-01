class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        for(char c : ch){
            if(Character.isLetterOrDigit(c)){
                sb.append(c);
            }
        }
        
        String realS = sb.toString();
        int start = 0, end = realS.length()-1;
        while(end > start){
            if(realS.charAt(end) != realS.charAt(start))
                return false;
            end--;
            start++;
        }
        return true;
    }
}