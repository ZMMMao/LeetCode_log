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
input: TreeNode root, p, q
output: TreeNode the lowest common ancestor of two node
constraint: node.val are unique and in [-10^9, 10^9], numbers of node in [2, 10^5]

clarify:
guaranteed the p and q are in the tree?
p != q?

approach:
if(root == null || root == p || root == q) return root;
left = lca(root.left, p, q)
right = lca(root.right, p, q)
if(


 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
}