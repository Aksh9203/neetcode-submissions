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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        heightOfBinaryTree(root);
        return diameter;
    }

    public int heightOfBinaryTree(TreeNode root){
        if(root == null) return 0;

        int leftPart = heightOfBinaryTree(root.left);
        int rightPart = heightOfBinaryTree(root.right);

        diameter = Math.max(diameter, leftPart + rightPart);

        return 1 + Math.max(leftPart, rightPart);
    }
}
