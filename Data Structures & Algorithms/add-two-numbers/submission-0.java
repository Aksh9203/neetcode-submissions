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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        int carry = 0;

        while(curr1 != null || curr2 != null){
            int sum = carry;

            if(curr1 != null){
                sum += curr1.val;
                curr1 = curr1.next;
            }
            if(curr2 != null){
                sum += curr2.val;
                curr2 = curr2.next;
            }

            tail.next = new ListNode(sum%10);
            tail = tail.next;
            carry = (sum/10);
        }

        if(carry != 0){
            tail.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
