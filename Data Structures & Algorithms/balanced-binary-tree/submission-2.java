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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return check(root) != -1;
    }

    public int check(TreeNode root){
        if(root == null) return 0;

        int leftPart = check(root.left);
        if(leftPart == -1) return -1;

        int rightPart = check(root.right);
        if(rightPart == -1) return -1;

        if(Math.abs(leftPart - rightPart) > 1){
            return -1;
        }

        return 1 + Math.max(leftPart, rightPart);
    }
}
