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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int n = inorder.length;

        for(int i=0; i<inorder.length; i++){
            mp.put(inorder[i],i);
        }

        return tree(mp, inorder, 0, n-1, preorder, 0, n-1);
    }

    public TreeNode tree(HashMap<Integer,Integer> mp, int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd){
        if(inStart > inEnd || preStart > preEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = mp.get(preorder[preStart]);
        int left = inRoot - inStart;

        root.left = tree(mp, preorder, inStart, inRoot - 1, preorder, preStart + 1, preStart + left);
        root.right = tree(mp, preorder, inRoot + 1, inEnd, preorder, preStart + left + 1, preEnd);

        return root;
    }
}
