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
        dummy.next = head;
        ListNode tail = dummy;
        ListNode curr1 = dummy;
        ListNode curr2 = head;

        for(int i = 1; i < left; i++){
            curr1 = curr1.next;
        }

        for(int i = 1; i<=right; i++){
            curr2 = curr2.next;
        }

        ListNode temp = curr1.next;

        for(int i = left; i<right; i++){
            temp = temp.next;
        }

        ListNode remember = curr1.next;

        temp.next = null;
        temp = curr1.next;
        ListNode prev = null;

        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        curr1.next = prev;
        remember.next = curr2;

        return dummy.next;
    }
}