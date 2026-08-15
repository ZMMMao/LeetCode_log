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
 level order traversal, left to right
 BFS
 TC: O(n)
 SC: O(n)
  */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<List<Integer>> levels = new ArrayList<>();

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);        
            }
            levels.add(level);
        }

        return levels;
    }
}

/**
Dry run:
[1, 9, 20, null, 7]
Queue                  size                 level                   levels
[1] -> [9, 20]          1                     {1}                       {{1}}
[9, 20] -> [20, 7]      2, at i=0             {9}
[20, 7] -> [7]          2, at i=1 done        {9, 20}                   {{1}, {9, 20}}
[7] -> []               1                     {7}                       {{1}, {9,20}, {7}} -- return

Follow up:
if zigzag order? left and then right
a boolean checker, if left offer left first, ves versa
 */