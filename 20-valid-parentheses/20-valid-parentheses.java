class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        
        for(int i = 0; i < s.length(); i++){
            char tmp = s.charAt(i);
            if(tmp == '(')
                stack.push(')');
            else if(tmp == '[')
                stack.push(']');
            else if(tmp == '{')
                stack.push('}');
            else if(stack.isEmpty() || stack.pop() != tmp)
                return false;
        }
        
        return stack.isEmpty();
    }
}