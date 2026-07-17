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
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode temp = slow;
        ListNode prev = null;

        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode curr1 = head;
        ListNode curr2 = prev;

        while(curr1 != null){
            tail.next = curr1;
            ListNode front = curr1.next;
            ListNode front1 = curr2.next;
            curr1.next = curr2;
            curr1 = front;
            curr2.next = curr1;
            curr2 = front1;
        }
    }
}
