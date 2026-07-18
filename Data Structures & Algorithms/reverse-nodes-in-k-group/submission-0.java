/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode prevNode = null, nextNode = null;

        while(curr != null){
            ListNode k_node = kNode(curr,k);

            if(k_node == null){
                if(prevNode != null){
                    prevNode.next = curr;
                }
                break;
            }

            nextNode = k_node.next;
            k_node.next = null;
            reverse(curr);

            if(curr == head){
                head = k_node;
            }
            else{
                prevNode.next = k_node;
            }

            prevNode = curr;
            curr = nextNode;
        }

        return head;  
    }

    public ListNode kNode(ListNode head, int k){
        ListNode curr = head;

        for(int i=0; i<k-1; i++){
            if(curr == null){
                return null;
            }
            curr = curr.next;
        }

        return curr;
    }

    public void reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
    }
}
