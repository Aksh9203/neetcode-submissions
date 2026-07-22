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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();

        if(root == null) return ls;
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            while(size > 1){
                TreeNode top = q.poll();
                size--;
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
            }

            TreeNode top = q.poll();
            ls.add(top.val);
            if(top.left != null) q.add(top.left);
            if(top.right != null) q.add(top.right);
        }

        return ls;
    }
}
