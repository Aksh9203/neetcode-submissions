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
        ArrayList<Integer> ls = new ArrayList<>();
        find(root,ls);

        return ls.get(k-1);
    }

    public void find(TreeNode root, ArrayList<Integer> ls){
        if(root == null) return;

        find(root.left,ls);
        ls.add(root.val);
        find(root.right,ls);
    }
}
