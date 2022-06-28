class Trie {
    class TNode{
        public boolean isWord;
        public TNode[] child;
        public TNode(){
            child = new TNode[26];
            isWord = false;
        }
    }
    
    private TNode root;
    
    public Trie() {
        this.root = new TNode();
    }
    
    public void insert(String word) {
        if(word == null)
            return;
        
        TNode dummy = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(dummy.child[idx] == null)
                dummy.child[idx] = new TNode();
            dummy = dummy.child[idx];    
        }
        dummy.isWord = true;
    }
    
    public boolean search(String word) {
        TNode dummy = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(dummy.child[idx] == null)
                return false;
            dummy = dummy.child[idx];
        }
        return dummy.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TNode dummy = root;
        for(int i = 0; i < prefix.length(); i++){
            int idx = prefix.charAt(i) - 'a';
            if(dummy.child[idx] == null)
                return false;
            dummy = dummy.child[idx];
        }
        return true;
    }
}



/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */