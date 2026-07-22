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

        for(int i = 0; i<preorder.length; i++){
            mp.put(inorder[i],i);
        }

        TreeNode root = bTree(mp, preorder, 0, preorder.length - 1, inorder, 0, inorder.length);
        return root;
    }

    public TreeNode bTree(HashMap<Integer, Integer> mp, int[] preorder, int preStart,
        int preEnd, int[] inorder, int inStart, int inEnd){
            if(preStart> preEnd || inStart > inEnd) return null;

            TreeNode newNode = new TreeNode(preorder[preStart]);

            int root = mp.get(preorder[preStart]);
            int left = root - inStart;

            newNode.left = bTree(mp, preorder, preStart + 1, preStart + left, inorder, inStart, root - 1);
            newNode.right = bTree(mp, preorder, preStart + left + 1, preEnd, inorder, root + 1, inEnd);

            return newNode;
        }
}
