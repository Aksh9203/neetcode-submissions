/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        HashMap<Node,Node> mp = new HashMap<>();
        Node cloneNode = new Node(node.val);
        mp.put(node,cloneNode);

        dfs(node,cloneNode,mp);
        return cloneNode;
    }

    public void dfs(Node node, Node cloneNode, HashMap<Node,Node> mp){
        for(Node n : node.neighbors){
            if(!mp.containsKey(n)){
                Node clone = new Node(n.val);
                mp.put(n,clone);
                cloneNode.neighbors.add(clone);

                dfs(n,clone,mp);
            }
            else{
                cloneNode.neighbors.add(mp.get(n));
            }
        }
    }


}