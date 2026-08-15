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
 return only most right side node;
 BFS
 for each level:
    always adding the first poll: 
    then add its right
    then add left, no adding to list
 TC: O(n)
 SC: O(n)
  */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> right = new ArrayList<>();

        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeNode curr = queue.poll();
            right.add(curr.val);
            if(curr.right != null) queue.offer(curr.right);
            if(curr.left != null) queue.offer(curr.left);
            for(int i = 1; i < size; i++){
                TreeNode node = queue.poll();
                if(node.right != null) queue.offer(node.right);
                if(node.left != null) queue.offer(node.left);
            }
        }

        return right;
    }
}

/**
Dry run:
1 / {2, 3} / {4, 5, null, 6}

queue = [1]         right= []
    size = 1, poll(1), add(1) -> right = [1]
    offer (3) -> offer(2) -> queue = [3,2]

queue = [3, 2]      right = [1]
    size = 2, poll(3), add(3) -> right = [1, 3]; offer(6) -> queue = [2, 6]
    i = 1, poll(2), offer(5) -> offer(4)     -> queue = [6, 5, 4]

queue = [6, 5, 4]       right = [1, 3]
    size = 3, poll(6), add(6) -> right = [1, 3, 6]
    i = 1, poll(5)
    i = 2, poll(4)
    queue = [] -> return

return: [1, 3, 6]

follow-up:
how to do it by DFS?
a int depth checker
if(depth == res.size()) add
dfs(right, d+1, res)
dfs(left, ..)
 */