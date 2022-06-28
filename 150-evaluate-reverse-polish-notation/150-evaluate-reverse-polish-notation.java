class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
      
        for(String str : tokens){
            if(str.equals("+")){
                int first = stack.pop();
                int second = stack.pop();
                stack.add(first + second);
            }else if(str.equals("-")){
                int first = stack.pop();
                int second = stack.pop();
                stack .add(second - first);
            }else if(str.equals("/")){
                int first = stack.pop();
                int second = stack.pop();
                stack.add(second / first);
            }else if(str.equals("*")){
                int first = stack.pop();
                int second = stack.pop();
                stack.add(first * second);
            }else{
                System.out.println(str);
                stack.add(Integer.valueOf(str));
            }
        }
        return stack.pop();
    }
}