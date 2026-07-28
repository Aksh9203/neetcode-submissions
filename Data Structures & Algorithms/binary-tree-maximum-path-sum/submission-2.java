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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        check(root);
        return max;
    }

    public int check(TreeNode root){
        if(root == null) return 0;

        int left = check(root.left) < 0 ? 0 : check(root.left);
        int right = check(root.right) < 0 ? 0 : check(root.right);

        max = Math.max(max, root.val + left + right);

        return root.val + Math.max(left,right);
    }
}
