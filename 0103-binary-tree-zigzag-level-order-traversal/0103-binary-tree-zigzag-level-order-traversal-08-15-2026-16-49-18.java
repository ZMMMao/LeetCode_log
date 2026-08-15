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
 BFS and DFS
 node [0, 2000]
 safe for DFS, slightly better? quick in balanced tree
 TC: O(n)
 SC: O(h), balanced logn, skewed n
dfs: 
    depth checker
    return if root = null
    if depth = levels.size(), scale up, add new level
    recursion continues
  */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int depth, List<List<Integer>> res){
        if(root == null) return;
        if(depth == res.size()) res.add(new LinkedList<>());
        if(depth % 2 == 1) res.get(depth).addFirst(root.val);
        else res.get(depth).addLast(root.val);
        dfs(root.left, depth+1, res);
        dfs(root.right, depth+1, res);
    }
}