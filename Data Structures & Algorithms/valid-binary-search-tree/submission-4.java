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
    public boolean isValidBST(TreeNode root) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        if(root == null) return true;
        
        return valid(root,min,max);
    }

    public boolean valid(TreeNode root, int min, int max){
        if(root == null) return true;

        if(root.val >= max || root.val <= min) return false;

        boolean left = valid(root.left,min,root.val);
        boolean right = valid(root.right,root.val,max);

        return left && right;
    }
}
