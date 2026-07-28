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

// class TreeNode{
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(){}
//     Treenode(int val) {
//         this.val = val;
//     }
//     TreeNode(int val, TreeNode left, TreeNode Right){
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode leftN = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(leftN);
        
        return root;
    }
    
}
