/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 /**
 input:
    type: ListNode
    range: [0, 10^4]
    node.val: [-10^5, 10^5]
output:
    boolean cycle
edge case:
    head == null return false;
approach:
    fast and slow pointer
    if fast == null no cycle
    if fast meet slow, contains cycle
    TC: O(n)
    SC: O(1)
  */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }
}