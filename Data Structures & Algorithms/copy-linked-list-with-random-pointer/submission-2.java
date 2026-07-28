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

        HashMap<Node,Node> mp = new HashMap<>();

        while(temp != null){
            Node copyN  = new Node(temp.val);
            mp.put(temp,copyN);
            temp = temp.next;
        }

        temp = head;

        while(temp != null){
            Node copyN = mp.get(temp); 
            copyN.next = mp.get(temp.next);
            copyN.random = mp.get(temp.random);
            temp = temp.next;
        }

        return mp.get(head);
    }
}
