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
    HashMap<Integer, TreeNode> parent = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        traverse(root, null);

        Queue<TreeNode> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.offer(target);
        visited.add(target.val);

        int dist = 0;
        List<Integer> res = new LinkedList<>();

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if (dist == k) {
               
                    res.add(cur.val);
                }

                TreeNode parentNode = parent.get(cur.val);
                if (parentNode != null && !visited.contains(parentNode.val)) {
                    visited.add(parentNode.val);
                    q.offer(parentNode);
                }
                if (cur.left != null && !visited.contains(cur.left.val)) {
                    visited.add(cur.left.val);
                    q.offer(cur.left);
                }
                if (cur.right != null && !visited.contains(cur.right.val)) {
                    visited.add(cur.right.val);
                    q.offer(cur.right);
                }
            }
            
            dist++;
        }

        return res;
    }

    private void traverse(TreeNode root, TreeNode parentNode) {
        if (root == null) {
            return;
        }
        parent.put(root.val, parentNode);

        traverse(root.left, root);
        traverse(root.right, root);
    }
}