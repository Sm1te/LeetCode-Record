/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    
    public void dfs(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#,");
            return;
        }
        
        sb.append(root.val + ",");
        
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    /* 将字符串反序列化为二叉树结构 */
    TreeNode deserialize(String data) {
        if(data == null || data.length() == 0)
            return null;
        
        LinkedList<String> list = new LinkedList();
        for(String tmp : data.split(","))
            list.addLast(tmp);
        
        return helper(list);
    }
    
    TreeNode helper(LinkedList<String> list){
        if(list.isEmpty())
            return null;
        if(list.peekFirst().equals("#")){
            list.removeFirst();
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(list.removeFirst()));
        
        root.left = helper(list);
        root.right = helper(list);
        
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));