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
        List<List<Integer>> ls = new ArrayList<>();

        if(root == null) return ls;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> ans = new ArrayList<>();

            for(int i=0; i<size; i++){
                TreeNode top = q.poll();
                ans.add(top.val);

                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
            }
            ls.add(ans); 
        }

        return ls;
    }
}
