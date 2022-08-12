class Solution {
    public int minInsertions(String s) {
        int res = 0, need = 0;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '('){
                need += 2;
                if(need % 2 == 1){
                    res++;
                    need--;
                }
            }else{
                need--;
                if(need == -1){
                    res++;
                    need = 1;
                }
            }
        }
        return res + need;
    }
}