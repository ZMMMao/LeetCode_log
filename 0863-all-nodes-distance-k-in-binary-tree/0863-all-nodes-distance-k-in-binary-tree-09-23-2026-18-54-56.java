/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
restate: a binary tree, return node from k dist of the target node
clarify: guaranteed have
approach: 
    child-parent map graph 
    build graph cost O(n), enqueue is also a O(n) space and 
    TC: O(n)
    SC: O(n)

*/
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root == null) return new ArrayList<>();

        Map<TreeNode, TreeNode> graph = new HashMap<>();

        traverse(root, null, graph);

        Deque<TreeNode> q = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        int dist = 0;
        q.offer(target);
        visited.add(target);
        while(!q.isEmpty() && dist <= k){
            int sz = q.size();
            for(int i = 0; i < sz; i++){
                TreeNode curr = q.poll();
                visited.add(curr);
                if(dist == k) res.add(curr.val);
                if(graph.get(curr) != null && !visited.contains(graph.get(curr))) q.offer(graph.get(curr));
                if(curr.left != null && !visited.contains(curr.left)) q.offer(curr.left);
                if(curr.right != null && !visited.contains(curr.right)) q.offer(curr.right);
            }
            dist++;
        }
        return res;
    }

    private void traverse(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> graph){
        graph.put(root, parent);
        if(root.left != null) traverse(root.left, root, graph);
        if(root.right != null) traverse(root.right, root, graph);
    }
}