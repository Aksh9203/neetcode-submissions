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
    int cnt = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return cnt;
        check(root, Integer.MIN_VALUE);
        return cnt;
    }

    public void check(TreeNode root, int max){
        if(root == null) return;

        if(root.val >= max){
            cnt++;
            max = root.val;
        }

        check(root.left, max);
        check(root.right, max);
    }
}
