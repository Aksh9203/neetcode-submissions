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
        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        q.add(root);

        while(!q.isEmpty()){
            List<Integer> ls = new ArrayList<>();
            int size = q.size();

            for(int i=0; i<size; i++){
                TreeNode top = q.poll();
                ls.add(top.val);
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
            }

            res.add(ls);
        }
        return res;
    }
}
