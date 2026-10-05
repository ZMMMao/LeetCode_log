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
    input: TreeNode root, int targetSum
    output: list of paths
    constraint: number of nodes in [0, 5000], node.val in [-1000, 1000], targetSum in [-1000, 1000]

clarify:
    only root to leaf, no early stop?
    integer range?
    tree is sorted or not?

approach:
    dfs method
    base case: check if next node is not null, continue;
    add current in the path
    recurse the neighbors
    remove current from the path
    record once targetSum == 0 and it's leaf

    TC: O(nlogn), n for visit the whole tree, logn for creating the answer path (root to leaf)
    SC: O(logn)

edge case: 
    empty tree, positive and negtive mixed tree

dry-run: tree: [0, 1, -1, 0, 1, null, 2], targetSum = 1
         0
       /   \
      1      -1
    /  \    /   \
    0   1  null  2 

dfs(node=0, remain=1, path=[])         非叶子 → path=[0]
  dfs(node=1, remain=1, path=[0])      非叶子 → path=[0,1]
    dfs(node=0, remain=0, path=[0,1])  叶子，0-0==0 → 记录 [0,1,0] ✓
    dfs(node=1, remain=0, path=[0,1])  叶子，0-1≠0 ✗
                                        remove → [0]
  dfs(node=-1, remain=1, path=[0])     非叶子 → path=[0,-1]
                                        左孩子 null，跳过
    dfs(node=2, remain=2, path=[0,-1]) 叶子，2-2==0 → 记录 [0,-1,2] ✓
                                        remove → [0]
res = [[0,1,0], [0,-1,2]]
    

follow-up:
    if val in int range, need to consider overflow for negative mid-calculations

    LC 437 Path Sum III: a part of trees that contains targetSum

*/
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode node, int target, List<Integer> path, List<List<Integer>> res){
        if(node.left == null && node.right == null){
            if(target - node.val == 0){
                path.add(node.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }

        path.add(node.val);
        if(node.left != null) dfs(node.left, target - node.val, path, res);
        if(node.right != null) dfs(node.right, target - node.val, path, res);
        path.remove(path.size() - 1);
    }
}