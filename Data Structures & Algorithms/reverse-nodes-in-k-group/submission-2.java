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
        ListNode nextNode = null;
        ListNode prevNode = null;

        while(temp != null){
            ListNode kNode = kLength(temp,k);

            if(kNode == null){
                if(prevNode != null){
                    prevNode.next = nextNode;
                }
                break;
            }

            nextNode = kNode.next;
            kNode.next = null;
            reverse(temp);

            if(temp == head){
                head = kNode;
            }else{
               prevNode.next = kNode; 
            }

            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }

    public ListNode kLength(ListNode head, int k){
        ListNode temp = head;
        
        for(int i=0; i<k - 1; i++){
            if(temp != null){
                temp = temp.next;
            }    
        }

        return temp;
    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode temp = head;
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
