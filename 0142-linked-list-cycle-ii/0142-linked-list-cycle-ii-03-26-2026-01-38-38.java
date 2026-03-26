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

TC: O(n)
SC: O(1)
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                slow = head;
                while(slow != null & slow.next != null){
                    if(slow == fast) return fast;
                    slow = slow.next;
                    fast = fast.next;
                }
            }
        }
        return null;
    }
}