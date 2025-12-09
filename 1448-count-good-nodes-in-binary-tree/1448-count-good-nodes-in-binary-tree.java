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
input/output:
    - input type: TreeNode
    - input size: 1, 10^5
    - input value range: -10^4, 10^4
    - output type: int good
edge case:
    null return root
approach:
    - save max as current max
    - compare as we traverse left and right
    - update current max and good nodes
    - TC: O(n)
    - SC: O(logn) recursion,
**** hint: iteration/BFS for solving very large node size issue on call stack
*/
class Solution {
    int good = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        int best = root.val;
        traverse(best, root);
        return good;
    }

    private void traverse(int best, TreeNode node){
        if(node == null) return;
        if(node.val >= best){
            good++;
            best = node.val;
        }
        traverse(best, node.left);
        traverse(best, node.right);
    }
}