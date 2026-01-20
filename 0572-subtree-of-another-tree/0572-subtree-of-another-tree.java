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
tree traverse
input root, subRoot
output T/F
input size -10^4 - 10^4
 TC: O(n * min(n, m))
 SC: O(n)
  */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        return isSameTree(root, subRoot) || 
                isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode a, TreeNode b){
        if(a == null || b == null) return a == b;

        return a.val == b.val && isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }
}