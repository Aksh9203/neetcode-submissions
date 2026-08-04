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
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        prev.next = head;

        for(int i=1; i<left; i++){
            prev = prev.next;
        }

        ListNode reversalStart = prev.next;
        ListNode tail = null;
        ListNode temp = prev.next;

        for(int i=left; i<=right; i++){
            ListNode front = temp.next;
            temp.next = tail;
            tail = temp;
            temp = front;
        }

        reversalStart.next = temp;
        prev.next = tail;

        return dummy.next;
    }
}