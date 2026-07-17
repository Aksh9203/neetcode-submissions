/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        HashMap<Node,Node>  mp = new HashMap<>();

        while(curr != null){
            Node copy = new Node(curr.val);
            mp.put(curr,copy);
            curr = curr.next;
        }

        curr = head;

        while(curr != null){
            Node copyNode = mp.get(curr);
            copyNode.random = mp.get(curr.random);
            copyNode.next = mp.get(curr.next);

            curr = curr.next;
        }

        return mp.get(head);
    }
}
