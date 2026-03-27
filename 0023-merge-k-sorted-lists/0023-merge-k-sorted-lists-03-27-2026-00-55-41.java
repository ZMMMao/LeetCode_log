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
 input:
    type: ListNode[]
    size: [0, 500]
    lists.length: [0, 10^4]
    node val: [-10^4, 10^4]
output:
    ListNode
edge case:
 [] return []
 [[]] return []
Appraoch:
    minHeap
    k = list.length()
    n = total number of nodes
    TC: O(nlogk)
    SC: O(k)
 
  */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(-1), p = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode l : lists){
            if(l == null) continue;
            minHeap.offer(l);
        }

        while(!minHeap.isEmpty()){
            ListNode curr = minHeap.poll();
            p.next = curr;
            if(curr.next != null){
                curr = curr.next;
                minHeap.offer(curr);
            }
            p = p.next;
        }

        return dummy.next;
    }
}