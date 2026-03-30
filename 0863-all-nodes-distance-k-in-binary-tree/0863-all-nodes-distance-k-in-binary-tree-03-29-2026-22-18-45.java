/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root == null || target == null) return new ArrayList<>();

        Map<TreeNode, TreeNode> graph = new HashMap<>();

        traverse(graph, root, null);

        int dist = 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        while(!q.isEmpty()){
            if(dist == k){
                List<Integer> res = new ArrayList<>();
                for(TreeNode node : q){
                    res.add(node.val);
                }
                return res;
            }

            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                TreeNode[] neighbors = {curr.left, curr.right, graph.get(curr)};
                for(TreeNode next : neighbors){
                    if(next != null && !visited.contains(next)){
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }

            dist++;
        }

        return new ArrayList<>();
    }

    private void traverse(Map<TreeNode, TreeNode> graph, TreeNode root, TreeNode parent){
        if(root == null)return;
        graph.put(root, parent);
        traverse(graph, root.left, root);
        traverse(graph, root.right, root);
    }
}