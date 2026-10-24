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
    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        check(root);
        return sum;
    }

    private int check(TreeNode root){
        if(root == null) return 0;

        int left = Math.max(check(root.left),0);
        int right = Math.max(check(root.right),0);
        sum = Math.max(sum, right + left + root.val);

        return root.val + Math.max(left,right);
    }
}
