/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
/**
The 3-Pass Strategy:
    1. Weave: Insert each cloned node directly after its original node. (A -> A' -> B -> B')
    2. Link Randoms: Now, if A's random points to C, then A''s random should point to C'. Because C' is right next to C, we can easily find it: A.next.random = A.random.next.
    3. Unweave: Separate the merged list back into two distinct lists.
 */
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;

        Node curr = head;
    
        while(curr != null){
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        curr = head;

        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node cloneHead = head.next;
        Node cloneCurr = cloneHead;
        
        //restore
        while(curr != null){
            curr.next = curr.next.next;
            if(cloneCurr.next != null){
                cloneCurr.next = cloneCurr.next.next;
            }

            curr = curr.next;
            cloneCurr = cloneCurr.next; 
        }
        return cloneHead;
    }
}