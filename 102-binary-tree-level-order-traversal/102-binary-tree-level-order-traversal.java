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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList();
        
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList();
            for(int i = 0; i < size; i++){
                TreeNode tmp = queue.poll();
                list.add(tmp.val);
                if(tmp.left != null)
                    queue.offer(tmp.left);
                if(tmp.right != null)
                    queue.offer(tmp.right);
            }
            res.add(new ArrayList(list));
        }
        
        return res;
    }
}