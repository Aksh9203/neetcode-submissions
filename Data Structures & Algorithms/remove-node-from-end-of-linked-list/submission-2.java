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

// class ListNode{
//     int val;
//     ListNode next;
//     ListNode(){};
//     ListNode(int val){
//         this.val = val;
//     }
//     ListNode(int val, ListNode next){
//         this.val = val;
//         this.next = next;
//     }
// }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int cnt = 0;

        while(curr != null){
            cnt++;
            curr = curr.next;
        }

        int k = cnt - n;
        if(k == 0) return head.next;
        curr = head;

        for(int i=0; i<k-1; i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return head;
    }
}
