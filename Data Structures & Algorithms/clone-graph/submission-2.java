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
        Node copy = new Node(node.val);

        mp.put(node,copy);
        dfs(node,copy,mp);

        return copy;
    }

    public void dfs(Node node, Node copy, HashMap<Node,Node> mp){
        for(Node n : node.neighbors){
            if(!mp.containsKey(n)){
                Node copyN = new Node(n.val);
                mp.put(n,copyN);

                copy.neighbors.add(copyN);

                dfs(n,copyN,mp);
            }
            else{
                copy.neighbors.add(mp.get(n));
            }
        }
    }
}