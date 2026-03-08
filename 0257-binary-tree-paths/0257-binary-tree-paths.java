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
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();

        path(root, res, new StringBuilder());
        return res;
    }

    private void path(TreeNode node, List<String> res, StringBuilder sb){
        int currLen = sb.length();
        
        sb.append(node.val);
        
        if(node.left == null && node.right == null){
            res.add(sb.toString());
        }
        
        if(node.left != null){
            sb.append("->");
            path(node.left, res, sb);
            sb.setLength(sb.length() - 2);
        }

        if(node.right != null){
            sb.append("->");
            path(node.right, res, sb);
            sb.setLength(sb.length() - 2);
        }

        sb.setLength(currLen);
    }
}