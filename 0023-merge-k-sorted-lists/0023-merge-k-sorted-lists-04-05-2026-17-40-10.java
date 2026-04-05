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
/**
 
 
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode list : lists){
            if(list != null){
                minHeap.offer(list);
            }
        }

        ListNode res = new ListNode();
        ListNode node = res;

        while(!minHeap.isEmpty()){
            ListNode curr = minHeap.poll();
            node.next = curr;
            node = node.next;
            if(curr.next != null) minHeap.offer(curr.next);
        }

        return res.next;
    }
}