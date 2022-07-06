/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    Map<Node, Node> visited = new HashMap();
    public Node cloneGraph(Node node) {
        // 如果这层的node是null直接返回
        if (node == null) {
            return node;
        }
        // 如果之前有，就直接返回，这样不会形成环
        if(visited.containsKey(node))
            return visited.get(node);
        
        Node tmp = new Node(node.val, new ArrayList<Node>());
        visited.put(node, tmp);
        
        // 也要复制他们的child
        for(Node next : node.neighbors)
            tmp.neighbors.add(cloneGraph(next));
        
        // 最终返回
        return tmp;
    }
}