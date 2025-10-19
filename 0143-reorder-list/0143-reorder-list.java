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
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode curr = second;
        while(curr != null){
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        ListNode one = head;
        second = prev;
        while(second != null){
            ListNode tmp1 = one.next;
            ListNode tmp2 = second.next;
            one.next = second;
            second.next = tmp1;
            one = tmp1;
            second = tmp2;
        }
        return;
    }
}
/**
mid-point reverse + insertion
TC: O(n)
SC: O(1)
 */