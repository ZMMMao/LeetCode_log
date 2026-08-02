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
 tree invertion
  */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        
        traverse(root);
        return root;
    }
    private void traverse(TreeNode root){
        if(root == null) return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        traverse(root.left);
        traverse(root.right);
    }
} 