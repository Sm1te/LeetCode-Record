class MyLinkedList {
    class Node{
        int val;
        Node next;
        Node prev;
        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
        public Node(int val){
            this.val = val;
        }
    }
    Node dummy; 
    Node tail;
    int len;
    public MyLinkedList() {
        dummy = new Node(-1);
        tail = new Node(-1);
        tail.prev = dummy;
        dummy.next = tail;
        len = 0;
    }
    
    public int get(int index) {
        Node root = dummy.next;
        if(index >= len)
            return -1;
        while(index-- > 0){
            root = root.next;
        }
        return root.val;
    }

    public Node getNode(int index) {
        Node root = dummy.next;
        while(index-- > 0){
            if(root == null)
                return null;
            root = root.next;
        }
        return root;
    }
    
    public void addAtHead(int val) {
        Node root = dummy.next;
        Node add = new Node(val, root);
        add.prev = dummy;
        root.prev = add;
        dummy.next = add;
        len++;
    }
    
    public void addAtTail(int val) {
        Node pigu = tail.prev;
        Node add = new Node(val, tail);
        tail.prev = add;
        add.prev = pigu;
        pigu.next = add;
        len++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > len)
            return;
        Node target = getNode(index);
        if(target == null)
            return;
        Node prev = target.prev;
        Node add = new Node(val, target);
        add.prev = prev;
        prev.next = add;
        target.prev = add;
        len++;
    }
    
    public void deleteAtIndex(int index) {
        if(index >= len)
            return;
        Node target = getNode(index);
        if(target == null)
            return;
        Node prev = target.prev;
        Node next = target.next;
        prev.next = next;
        next.prev = prev;
        len--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */