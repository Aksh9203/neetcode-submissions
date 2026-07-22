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
    // int maxD;
    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        max(root);
        return sum;
    }

    public int max(TreeNode root){
        if(root == null) return 0;

        int left = (max(root.left) < 0) ? 0 : max(root.left);
        int right =  max(root.right) < 0 ? 0 : max(root.right);
        // sum = Math.max(root.val, Math.max(root.val + left + right, Math.max(root.val + left, root.val + right)));
        sum = Math.max(sum, root.val + left + right);

        return root.val + Math.max(left, right);
    }
}
