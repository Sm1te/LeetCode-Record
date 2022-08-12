class Solution {
    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque();
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '(')
                stack.push(')');
            else if(cur == '[')
                stack.push(']');
            else if(cur == '{')
                stack.push('}');
            else{
                if(stack.isEmpty()){
                    res++;
                    continue;
                }
                if(stack.peek() != cur)
                    res++;
                stack.pop();
            }
        }
        return res + stack.size();
    }
}