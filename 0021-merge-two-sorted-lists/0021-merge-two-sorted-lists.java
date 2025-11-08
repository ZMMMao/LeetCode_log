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
 dummy head

  */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode prev1 = list1;
        ListNode prev2 = list2;
        while(prev1 != null && prev2 != null){
            if(prev1.val > prev2.val){
                p.next = prev2;
                prev2 = prev2.next;
            }else{
                p.next = prev1;
                prev1 = prev1.next;
            }
            p = p.next;
        }
        if(prev1 != null) p.next = prev1;
        if(prev2 != null) p.next = prev2;
        return dummy.next;
    }
}
/**
TC: O(n)
SC: O(1)
 */