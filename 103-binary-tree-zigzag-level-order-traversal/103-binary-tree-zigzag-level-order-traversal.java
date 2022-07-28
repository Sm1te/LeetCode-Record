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
    boolean left;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        left = false;
        res = new ArrayList();
        if(root == null)
            return res;
        
        Queue<TreeNode> que = new LinkedList();
        que.offer(root);
        while(!que.isEmpty()){
            List<Integer> list = new ArrayList();
            int size = que.size();
            while(size-- > 0){
                TreeNode tmp = que.poll();
                list.add(tmp.val);
                if(tmp.left != null)
                    que.offer(tmp.left);
                if(tmp.right != null)
                    que.offer(tmp.right);
            }
            if(left)
                Collections.reverse(list);
            left = !left;
            res.add(new ArrayList(list));
        }
        return res;
    }
}