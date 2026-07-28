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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        List<Integer> ls = new ArrayList<>();

        check(root,ls);
        return ls.get(k - 1);
    }

    public void check(TreeNode root, List<Integer> ls){
        if(root == null) return;

        check(root.left,ls);
        ls.add(root.val);
        check(root.right,ls);
    }
}
