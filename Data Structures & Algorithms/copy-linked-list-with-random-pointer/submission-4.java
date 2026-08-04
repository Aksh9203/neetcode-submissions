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
        Node temp = head;

        HashMap<Node, Node> mp = new HashMap<>();

        while(temp != null){
            Node copy = new Node(temp.val);
            mp.put(temp,copy);
            temp = temp.next;
        }

        temp = head;

        while(temp != null){
            Node copy = mp.get(temp);
            copy.next = mp.get(temp.next);
            copy.random = mp.get(temp.random);
            temp = temp.next;
        }

        return mp.get(head);
    }
}
