/**
public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right
    TreeNode(int x){
        val = x;
    }
}

input: TreeNode root, p, q;
output: TreeNode lca of p,q
constraint: nodes in [2, 10^5], node.val in [-10^9, 10^9]

clarify: 
guaranteed lca node in the tree?
p != q?
unqiue nodes?

approach:
base case: if root == p || root == q || root == null return; -> found
left, right
return left != null ? left : right;
 
 test case:
 Input: root = [3,5,1,6,2,0,8], p = 5, q = 1
lca(3)
-> lca(5) return p=5
-> lca(1) return q=1
-> l & r != null return root = 3

TC: O(n)
SC: O(h), O(logn) in average and O(n) in worst case

follow-up?
if p and q not guaranteed on the tree?
need check null on return, both l and r null means not found
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