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
    TreeNode root
    num of node: [0, 2000]
    node.val: [-1000, 1000]
output:
    List<List<Integer>>
edge case:
    root == null return new list
approach:
    BFS, queue
    TC: O(n)
    SC: O(n)


 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();

        q.offer(root);
        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> level = new LinkedList<>();
            for(int i = 0; i < sz; i++){
                TreeNode cur = q.poll();
                level.add(cur.val);
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
            res.add(level);
        }
        return res;
    }
}