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
/**
input:
    type Node
    node.val: [1, 100]
    node number: [0, 100]
output: 
    Node
edge case:
    empty node return empty as well
approach:
    build a graph
    TC: O(V + E)
    SC: O(V)
 */
class Solution {
    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) return node;
        
        return dfs(node);
    }

    private Node dfs(Node node){
        if(node == null) return node;

        if(map.containsKey(node)) return map.get(node);

        Node clone = new Node(node.val);
        map.put(node, clone);

        for(Node neighbor : node.neighbors){
            clone.neighbors.add(dfs(neighbor));
        }

        return clone;
    }
}