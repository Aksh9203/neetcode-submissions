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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(int i=0; i<lists.length; i++){
            pq.add(lists[i]);
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while(pq.size() > 0){
            ListNode node = pq.remove();
            tail.next = node;
            tail = tail.next;

            node = node.next;
            if(node != null){
                pq.add(node);
            }
        }

        return dummy.next;
    }
}
