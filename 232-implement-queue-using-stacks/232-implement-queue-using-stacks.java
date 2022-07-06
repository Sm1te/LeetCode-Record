class MyQueue {
    Stack<Integer> In;
    Stack<Integer> Out;
    
    public MyQueue() {
        In = new Stack();
        Out = new Stack();
    }
    
    public void push(int x) {
        In.push(x);
    }
    
    public int pop() {
        while(!In.isEmpty())
            Out.push(In.pop());
        
        int res = Out.pop();
        while(!Out.isEmpty())
            In.push(Out.pop());
        
        return res;
    }
    
    public int peek() {
        while(!In.isEmpty())
            Out.push(In.pop());
        
        int res = Out.peek();
        
        while(!Out.isEmpty())
            In.push(Out.pop());
        
        return res;
    }
    
    public boolean empty() {
        return In.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */