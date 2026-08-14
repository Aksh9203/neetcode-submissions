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
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> ls = new ArrayList<>();
            int size = q.size();

            for(int i=0; i<size; i++){
                TreeNode top = q.poll();

                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);

                ls.add(top.val);
            }
            res.add(ls);
        }

        return res;
    }
}
