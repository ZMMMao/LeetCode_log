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
input: listNode, 2 list
output: listNode, merged list
edge case: null return null
approach: 
dummy head, compare value and add smaller node

*/
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null)
            return list1 == null ? list2 : list1;

        if (list1.val > list2.val) {
            ListNode tmp = list1;
            list1 = list2;
            list2 = tmp;
        }

        ListNode dummy = new ListNode(-1, list1);

        while (list1.next != null && list2 != null) {
            if (list2.val < list1.next.val) {
                ListNode nxt = list2.next;
                list2.next = list1.next;
                list1.next = list2;
                list2 = nxt;
            }
            list1 = list1.next;
        }

        if (list2 != null) {
            list1.next = list2;
        }

        return dummy.next;
    }
}