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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i = 0; i<inorder.length; i++){
            mp.put(inorder[i],i);
        }

        TreeNode root = bTree(mp, postorder,0,postorder.length - 1, inorder,0,inorder.length - 1);
        return root;
    }

    public TreeNode bTree(HashMap<Integer,Integer> mp, int[] postorder, int postStart, int postEnd,
        int[] inorder, int inStart, int inEnd){

            if(postStart > postEnd || inStart > inEnd) return null;

            TreeNode newNode = new TreeNode(postorder[postEnd]);

            int root = mp.get(postorder[postEnd]);
            int left = root - inStart;

            newNode.left = bTree(mp, postorder, postStart, postStart + left - 1, inorder, inStart, root - 1);
            newNode.right = bTree(mp, postorder, postStart + left, postEnd - 1, inorder, root + 1, inEnd);

            return newNode;
        }
}