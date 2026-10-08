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
public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(TreeNode left, TreeNode right, int val){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

 */
/**
restate:
    input: TreeNode
    output: List of integer
    constraint: number of nodes in [0, 100], node.val in [-100, 100]

clarify:
    most right even on the left branch?

approach:
    bfs level order traverse, the last node on each level is the right most
    print the last in the res list
    TC: O(n)
    SC: O(width of tree)

testcase:
    [1, 2, 3, 4, null, null, null, 5]
dry-run:
queue: [1] -> [2, 3]
res:[] -> [1]

q: [2, 3] ->[4]
res: [1] -> [1, 3]

q: [4] -> [5]
res: [1, 3] -> [1, 3, 4]

q:[5] -> empty
res: [1,3, 4] -> [1, 3, 4, 5]

return res;

follow-up:
left first: could be the first element of each level
what about dfs? SC: O(h), better in space
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i <size; i++){
                TreeNode curr = queue.poll();
                if(i == size - 1) res.add(curr.val);
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
        }
        return res;
    }
}