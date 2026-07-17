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

        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = curr.next.next;
        }

        curr = head;

        while(curr != null){
            Node copy = curr.next;
            if(curr.random == null){
                copy.random = null;
            }
            else{
                copy.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node dummy = new Node(-1);
        Node tail = dummy;

        while(curr != null){
            tail.next = curr.next;
            curr.next = curr.next.next;
            curr = curr.next;
            tail = tail.next;
        }

        return dummy.next;
    }
}
