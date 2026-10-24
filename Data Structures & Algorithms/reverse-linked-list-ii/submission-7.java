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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head;

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        tail.next = head;

        for(int i=1; i<left; i++){
            tail = tail.next;
        }

        ListNode lastKnown = tail.next;
        ListNode prev = null;
        temp = tail.next;

        for(int i=left; i<=right; i++){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        lastKnown.next = temp;
        tail.next = prev;

        return dummy.next;
    }
}