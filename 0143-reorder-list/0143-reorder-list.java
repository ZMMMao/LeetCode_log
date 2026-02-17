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
    ListNode
ouput:
    void, reorder list
edge case:
    head == null return
approach:
    1. find midpoint
    2. reverse second half list
    3. insert second half one-by-one
    TC: O(n)
    SC: O(1)
  */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode slow = head, fast = head;

        // find midpoint
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        // reverse second half
        ListNode prev = null;
        while(second != null){
            ListNode nxt = second.next;
            second.next = prev;
            prev = second;
            second = nxt;
        }
        
        // interleave second half
        second = prev;
        ListNode first = head;
        while(second != null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }
}