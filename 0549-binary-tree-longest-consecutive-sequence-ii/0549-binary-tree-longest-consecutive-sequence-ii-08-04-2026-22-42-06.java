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
 in-order print + reversed in-order print
 left - root - right
 TC: O(n)
 SC: O(h)
  */
class Solution {
    public int longestConsecutive(TreeNode root) {
        findSequence(root);
        return res;
    }

    private int res = 0;

    private int[] findSequence(TreeNode root){
        if(root == null) return new int[]{0, 0};


        int[] left = findSequence(root.left);
        int[] right = findSequence(root.right);

        int left_incr = left[0], left_decr = left[1];
        int right_incr = right[0], right_decr = right[1];
        int root_incr = 1, root_decr = 1;

        if(root.left != null){
            if(root.left.val - 1 == root.val){
                root_incr += left_incr;
            }else if(root.left.val + 1 == root.val){
                root_decr += left_decr;
            }
        }


        if(root.right != null){
            if(root.right.val - 1 == root.val){
                root_incr = Math.max(root_incr, right_incr + 1);
            }else if(root.right.val + 1 == root.val){
                root_decr = Math.max(root_decr, right_decr + 1);
            }
        }

        res = Math.max(res, root_incr + root_decr - 1);

        return new int[]{root_incr, root_decr};
    }
}