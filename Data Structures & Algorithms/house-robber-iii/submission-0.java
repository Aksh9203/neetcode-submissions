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
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0],res[1]);
    }

    public int[] dfs(TreeNode root){
        if(root == null) return new int[]{0,0};

        int[] leftSide = dfs(root.left);
        int[] rightSide = dfs(root.right);

        int withRoot = root.val + leftSide[1] + rightSide[1];
        int withoutRoot = Math.max(leftSide[0],leftSide[1]) + Math.max(rightSide[0],rightSide[1]);

        return new int[]{withRoot,withoutRoot};
    }
}