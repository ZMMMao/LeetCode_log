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
 input:
    type: TreeNode
    node number: [1, 10^4]
    node.val: [-2^31, 2^31 - 1]
output:
    boolean
edge case:
    null return true
approach:
    traverse
    TC: O(n)
    SC: O(1)
  */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max){
        if(node == null) return true;

        if(node.val <= min || node.val >= max){
            return false;
        }

        return validate(node.left, min, node.val) &&
            validate(node.right, node.val, max);
    }
}