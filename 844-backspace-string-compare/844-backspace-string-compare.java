class Solution {
    public boolean backspaceCompare(String s, String t) {
        return getOriginal(s).equals(getOriginal(t));
    }

    public String getOriginal(String s){
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int r = 0;
        while(r < ch.length){
            if(ch[r] == '#'){
                r++;
                if(sb.length() > 0)
                    sb.deleteCharAt(sb.length() - 1);
                continue;
            }
            sb.append(ch[r++]);
        }
        return sb.toString();
    }
}