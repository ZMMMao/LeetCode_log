/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; 
 * }
 */
/**
count length of the list
n-1 point to n+1
dummy head !
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            cnt++;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        for(int i = 0; i < cnt - n; i++){
            prev = prev.next;
        }
        
        prev.next = prev.next.next;

        return dummy.next;
    }
}