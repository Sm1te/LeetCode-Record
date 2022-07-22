/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode> list = new ArrayList();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).val == p.val)
                if(i < list.size() - 1)
                    return list.get(i + 1);
        }
        
        return null;
    }
    
    public void dfs(TreeNode root){
        if(root == null)
            return;
        
        dfs(root.left);
        
        list.add(root);
        
        dfs(root.right);
    }
    
    
}