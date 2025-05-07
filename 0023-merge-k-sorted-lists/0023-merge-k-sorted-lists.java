/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
Algo: min-heap
Data Structure: min-heap(PQ), array, linked list
TC: O(nlogk) k is lists.length (num of lists)
SC: O(k)
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode l : lists){
            if(l != null){
                pq.offer(l);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            head.next = curr;
            head = head.next;
            if(curr.next != null){
                pq.offer(curr.next);
            }
        }
        return dummy.next;
    }
}