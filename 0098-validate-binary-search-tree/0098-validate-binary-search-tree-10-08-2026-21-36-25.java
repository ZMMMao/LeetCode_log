/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
input: treenode
output: true if a BST or false
constraint: number of nodes [1, 10^4], node.val in integer range
 
clarify:
need to be a completed tree or not?

approach:
    recursion, maintain the max.value and min.value
    if root == null return true;
    if root < min || root > max return false;
    return validate(root.left, max, root.val) && validate(root.right, root.val, min);

    TC: O(n)
    SC: O(h) average O(logn)
testcase:
[1, 2, 5, null, null, 4, 6]

follow-up:

*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return validate(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    private boolean validate(TreeNode root, long max, long min){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return validate(root.left, root.val, min) && validate(root.right, max, root.val);
    }
}