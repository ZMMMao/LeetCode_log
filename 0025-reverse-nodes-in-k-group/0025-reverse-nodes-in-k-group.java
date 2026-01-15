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
    type: ListNode, int
    range k: [1, 5000]
    node val: [0, 1000]
output:
    ListNode
edge case:
    k = 0 return head;
    head == null return head
approach:
    traverse/ reverse in a for loop
    TC: O(n)
    SC: O(1)
  */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode dummy = new ListNode(-1, head);

        int n = 0;
        while(head != null){
            head = head.next;
            n++;
        }

        head = dummy.next;
        ListNode p = dummy;
        ListNode cur = head;
        ListNode pre = null;


        while(n >= k){
            n = n-k;
            for(int i = 0; i<k; i++){
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }

            ListNode nxt = p.next;
            p.next.next = cur;
            p.next = pre;
            p = nxt;
        }

        return dummy.next;
    }
}