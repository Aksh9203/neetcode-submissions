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
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();

        if(root == null) return ans;

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> ls = new ArrayList<>();

            for(int i=0; i<size; i++){
                TreeNode top = q.poll();
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
                ls.add(top.val);
            }
            ans.add(ls);   
        }
        return ans;
    }
}
