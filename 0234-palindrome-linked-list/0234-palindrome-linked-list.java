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
 TC: O(n)
 SC: O(1)

  */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prv = null;
        ListNode curr = slow;
        while(curr != null){
            ListNode nxt = curr.next;
            curr.next = prv;
            prv = curr;
            curr = nxt;
        }

        while(prv != null){
            if(head.val != prv.val) return false;
            head = head.next;
            prv = prv.next;
        }
        return true;
    }
}