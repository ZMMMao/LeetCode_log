/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> lookup = new HashMap<>();
        return dfs(node, lookup);
    }

    public Node dfs(Node node, Map<Node, Node> lookup){
        if(node == null) return null;

        if(lookup.containsKey(node)) return lookup.get(node);

        Node copy = new Node(node.val, new ArrayList<Node>());
        lookup.put(node, copy);

        for(Node neighbor : node.neighbors){
            copy.neighbors.add(dfs(neighbor, lookup));
        }
        return copy;
    }
}
/**
TC: O(V + E)
SC: O(V)
 */