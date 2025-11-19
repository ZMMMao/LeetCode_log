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
input: TreeNode root
input size: [1, 10^4]
input range: int
output boolean isValid
null case: if null return true;
traverse: 
TC: O(n)
SC: O(n)
  */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long min, long max){
        if(root == null) return true;
        long x = root.val;
        if(x <= min || x >= max) return false;
        return isValid(root.left, min, x) && isValid(root.right, x, max);
    }
}