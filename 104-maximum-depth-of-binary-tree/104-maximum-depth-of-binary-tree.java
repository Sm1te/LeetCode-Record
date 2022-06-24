/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int depth = 0;
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root, 0);
        return depth;
    }
    
    public void dfs(TreeNode root, int dep){
        if(root == null)
            return;
        
        dep += 1;
        depth = Math.max(dep, depth);
        dfs(root.left, dep);
        dfs(root.right, dep);
    }
}