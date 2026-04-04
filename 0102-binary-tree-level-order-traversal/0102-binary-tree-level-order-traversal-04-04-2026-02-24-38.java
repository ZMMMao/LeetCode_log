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
preorder traverse, BFS
TC: O(n)
SC: O(n)
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new LinkedList<>();

        Queue<TreeNode> bfs = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
    
        bfs.offer(root);
        while(!bfs.isEmpty()){
            int size = bfs.size();
            List<Integer> level = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode curr = bfs.poll();
                level.add(curr.val);
                if(curr.left != null) bfs.offer(curr.left);
                if(curr.right != null) bfs.offer(curr.right);
            }
            res.add(level);
        }

        return res;
    }
}