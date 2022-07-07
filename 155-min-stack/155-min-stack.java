class MinStack {
    Deque<Integer> deq = new ArrayDeque();
    PriorityQueue<Integer> pq = new PriorityQueue();
    
    public MinStack() {
            
    }
    
    public void push(int val) {
        deq.addLast(val);
        pq.offer(val);
    }
    
    public void pop() {
        int val = deq.pollLast();
        pq.remove(val);
    }
    
    public int top() {
        return deq.peekLast();
    }
    
    public int getMin() {
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */