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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        Stack<ListNode> st = new Stack<>();

        ListNode temp = head;

        while(temp != null){
            st.add(temp);
            temp = temp.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy; 

        while(!st.isEmpty()){
            tail.next = st.pop();
            tail = tail.next;
        }
        tail.next = null;

        return dummy.next;
    }
}
