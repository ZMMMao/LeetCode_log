/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /**
 approach:
 it's possible p or q not exist
 need a global field found to trace the nodes
 use dfs to traverse, dfs remains lca logic:
    if node == null return node;
        left = lca(left)
        right = lca(right)
        if(node == p || q) found++;
        if(left!= and right !=) return node;
        return left != null ? left : right;

return to main funciton: if found == 2 return node or return null


 
  */
class Solution {
    private int found;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        found = 0;
        TreeNode res = dfs(root, p, q);
        return found == 2 ? res : null;
    }

    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return node;
        TreeNode left = dfs(node.left, p, q);
        TreeNode right = dfs(node.right, p, q);
        if(node == p || node == q) {
            found++; 
            return node;
        }

        if(left != null && right != null) return node;
        return left != null ? left : right;
    }
}