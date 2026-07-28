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
        int n = preorder.length;
        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            mp.put(inorder[i],i);
        }

        return tree(mp, inorder, 0, n-1, preorder, 0, n-1);
    }

    public TreeNode tree(HashMap<Integer,Integer> mp, int[] inorder, int inStart, int inEnd, 
            int[] preorder, int preStart, int preEnd){
        if(preEnd < preStart || inEnd < inStart) return null;

        TreeNode node = new TreeNode(preorder[preStart]);
        int root = mp.get(preorder[preStart]);
        int left = root - inStart;

        node.left = tree(mp, inorder, inStart, root - 1, preorder, preStart + 1, preStart + left);
        node.right = tree(mp, inorder, root + 1, inEnd, preorder, preStart + left + 1 ,preEnd);

        return node;
    }
}
