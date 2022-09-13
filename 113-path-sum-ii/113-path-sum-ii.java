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
    List<List<Integer>> res;
    LinkedList<Integer> tmp;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList();
        tmp = new LinkedList(); 
        dfs(root, target);
        return res;
    }

    public void dfs(TreeNode root, int target){
        if(root == null)
            return;
    
        target -= root.val;
        tmp.addLast(root.val);

        if(target == 0){
            if(root.left == null && root.right == null)
                res.add(new LinkedList(tmp));
        }

        dfs(root.left, target);
        dfs(root.right, target);
        tmp.removeLast();
    }
}