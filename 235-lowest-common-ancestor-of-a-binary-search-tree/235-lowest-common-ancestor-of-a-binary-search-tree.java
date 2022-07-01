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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 保证 val1 较小，val2 较大
        int val1 = Math.min(p.val, q.val);
        int val2 = Math.max(p.val, q.val);
        return find(root, val1, val2);
    }
    
    public TreeNode find(TreeNode root, int val1, int val2){
        if(root == null)
            return null;
        
        if(root.val > val2){
            return find(root.left, val1, val2);
        }else if(root.val < val1){
            return find(root.right, val1, val2);
        }
        return root;
    }
}