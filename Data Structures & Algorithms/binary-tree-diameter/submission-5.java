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
    int maxD = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        check(root);
        return maxD;
    }

    private int check(TreeNode root){
        if(root == null) return 0;

        int left = check(root.left);
        int right = check(root.right);

        maxD = Math.max(maxD, right + left);

        return 1 + Math.max(left,right);


    }
}
