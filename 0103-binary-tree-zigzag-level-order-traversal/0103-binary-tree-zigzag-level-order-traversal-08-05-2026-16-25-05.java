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
 zigzag left to right and next level r to l
 BFS level traverse, with a boolean mark
 TC: O(n)
 SC: O(n)
  */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        bfs(root, res);
        return res;
    }

    private void bfs(TreeNode root, List<List<Integer>> res){
        Queue<TreeNode> level = new ArrayDeque<>();
        boolean left = true;
        level.offer(root);
        while(!level.isEmpty()){
            int size = level.size();
            List<Integer> l = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curr = level.poll();
                l.add(curr.val);
                if(curr.left != null) level.offer(curr.left);
                if(curr.right != null) level.offer(curr.right);
            }
            if(left) res.add(l);
            if(!left) {Collections.reverse(l); res.add(l);}
            left = !left;
        }
    }
}