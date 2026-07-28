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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        q.add(root);

        while(!q.isEmpty()){
            TreeNode top = q.poll();

            if(top == null){
                sb.append("#" + " ");
                continue;
            }
            sb.append(top.val + " ");
            q.add(top.left);
            q.add(top.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;

        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        q.add(root);

        for(int i=1; i<values.length; i++){
            TreeNode parent = q.poll();
            if(!values[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(parent.left);
            }
            i++;

            if(!values[i].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(parent.right);
            }
        }

        return root;
    }
}
