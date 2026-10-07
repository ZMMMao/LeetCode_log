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
restate:
input: root of a binary tree
output: list of level order traversal
constraint: node number in [0, 2000], node.val in [-1000, 1000]

clarify:
order in each level
from top to bottom

approach:
BFS traversal
use a queue: 
push a root node and for current queue size, add current node to the list, enqueue the node's children
add current level to the res
TC: O(n)
SC: O(n)

test case:
[3, 5, 6, null, null, 12, 13]
queue: [3]
    level: [3], enqueue children -> queue: [5, 6]
queue: [5, 6]
    level: [5, 6], enqueue 6's children (5 is a leaf) -> [12, 13]
queue: [12, 13]
    level: [12, 13], all leaf nodes, nothing to enqueue

res:[[3], [5, 6], [12, 13]];


follow-up:
zigzag order?
use a boolean mark
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i<size; i++){
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            res.add(level);
        }
        return res;
    }
}