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

        int n = preorder.length;

        for(int i=0; i<n; i++){
            mp.put(inorder[i],i);
        }

        return buildNew(mp,preorder,0,n - 1,inorder,0, n - 1);
    }

    private TreeNode buildNew(HashMap<Integer,Integer> mp, int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd){
        if(inStart > inEnd || preStart > preEnd){
            return null;
        }

        TreeNode node = new TreeNode(pre[preStart]);
        int root = mp.get(pre[preStart]);
        int left = root - inStart;

        node.left = buildNew(mp,pre,preStart + 1,preStart + left, in, inStart, root - 1);
        node.right = buildNew(mp,pre,preStart + left + 1,preEnd,in, root + 1, inEnd);

        return node;
    }
}
