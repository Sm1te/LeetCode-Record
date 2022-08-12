class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque();

        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '(')
                stack.push(')');
            else if(cur == '[')
                stack.push(']');
            else if(cur == '{')
                stack.push('}');
            else{
                if(stack.isEmpty() || stack.peek() != cur)
                    return false;
                stack.pop();
            }
        }
        return stack.size() == 0;
    }
}