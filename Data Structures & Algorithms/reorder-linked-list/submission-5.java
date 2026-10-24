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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp2 = slow.next;
        slow.next = null;
        ListNode temp1 = head;
        
        ListNode prev = null;

        while(temp2 != null){
            ListNode front = temp2.next;
            temp2.next = prev;
            prev = temp2;
            temp2 = front;
        }

        temp2 = prev;
        while(temp2 != null){
            ListNode front1 = temp1.next;
            temp1.next = temp2;
            temp1 = front1;

            ListNode front2 = temp2.next;
            temp2.next = temp1;
            temp2 = front2;
        }

    }
}
