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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;

        int len = 0;

        while(temp != null){
            len++;
            temp = temp.next;
        }

        int remove = len - n;
        if(remove == 0) return head.next;

        temp = head;

        for(int i=0; i<remove - 1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }
}
