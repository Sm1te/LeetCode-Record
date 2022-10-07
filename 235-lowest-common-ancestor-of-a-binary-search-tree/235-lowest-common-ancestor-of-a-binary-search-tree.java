/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

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
        int val1 = p.val, val2 = q.val;
        if(root == null)
            return null;

        if(val1 > val2){
            int tmp = val1;
            val1 = val2;
            val2 = tmp;
        }

        return dfs(root, val1, val2);
    }

    public TreeNode dfs(TreeNode root, int val1 , int val2){
        if(root == null)
            return null;

        if(root.val > val2){
            return dfs(root.left, val1, val2);
        }else if(root.val < val1){
            return dfs(root.right, val1, val2);
        }

        return root;
    }
}