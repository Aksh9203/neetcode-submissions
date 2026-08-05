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
        int n = inorder.length;

        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            mp.put(inorder[i],i);
        }

        return tree(mp, preorder, 0, n-1, inorder, 0, n-1);
    }

    public TreeNode tree(HashMap<Integer,Integer> mp, int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode rootNode = new TreeNode(preorder[preStart]);
        int root = mp.get(preorder[preStart]);
        int left = root - inStart;

        rootNode.left = tree(mp, preorder, preStart + 1, preStart + left, inorder, inStart, root - 1);
        rootNode.right = tree(mp, preorder, preStart + left + 1, preEnd, inorder, root + 1, inEnd);

        return rootNode;
    }
}
