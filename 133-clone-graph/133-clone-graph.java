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
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        
        
        Map<Node, Node> visited = new HashMap();
        Queue<Node> queue = new LinkedList();
        queue.add(node);
        visited.put(node, new Node(node.val, new ArrayList()));
        
        while(!queue.isEmpty()){
            Node tmp = queue.poll();
            for(Node neighbor : tmp.neighbors){
                if(!visited.containsKey(neighbor)){
                    queue.offer(neighbor);
                    
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                }
                visited.get(tmp).neighbors.add(visited.get(neighbor));
                
            }
        }
        
        return visited.get(node);
    }
}