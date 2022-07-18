class Solution {
    List<String> res = new ArrayList();
    StringBuilder sb = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        backTrack(n, 0 ,0);
        return res;
    }
    
    public void backTrack(int n, int left, int right){
        if(sb.length() == 2 * n){
            res.add(sb.toString());
            return;
        }
        
        if(left < n){
            sb.append("(");
            backTrack(n, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if(right < left){
            sb.append(")");
            backTrack(n, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
 
    }
}