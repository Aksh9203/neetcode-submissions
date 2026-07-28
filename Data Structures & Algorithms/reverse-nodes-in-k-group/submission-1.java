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
        ListNode temp = head;
        ListNode prevNode = null, nextNode = null;

        while(temp != null){
            ListNode kth = knode(temp,k);
            
            if(kth == null){
                if(prevNode != null){
                    prevNode.next = temp;
                }
                break;
            }

            nextNode = kth.next;
            kth.next = null;
            reverse(temp);

            if(temp == head){
                head = kth;
            }
            else{
                prevNode.next = kth;
            }

            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }

    public ListNode knode(ListNode node, int k){
        for(int i=0; i<k-1; i++){
            if(node.next == null) return null;
            node = node.next;
        }

        return node;
    }

    public ListNode reverse(ListNode node){
        ListNode temp = node;
        ListNode prev = null;

        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }
}
