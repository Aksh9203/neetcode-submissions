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
        if(node == null) return node;
        HashMap<Node,Node> mp = new HashMap<>();

        Node copy = new Node(node.val);
        mp.put(node,copy);

        clone(node,mp);
        return copy;
    }

    public void clone(Node node, HashMap<Node,Node> mp){
        for(Node n : node.neighbors){
            if(!mp.containsKey(n)){
                Node copyN = new Node(n.val);
                mp.put(n,copyN);
                clone(n,mp);
            }
            mp.get(node).neighbors.add(mp.get(n));
        }
    }
}