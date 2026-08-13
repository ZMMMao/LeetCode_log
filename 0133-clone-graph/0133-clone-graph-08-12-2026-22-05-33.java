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
restate:
    input: one node on a connected undirected graph
    return a deep copy of it
clarify:
    what is clone?
    all new node in the neighbors
    order remains
approach:
brtue force:
    for node copy its value and for its neighbor, visit and copy its value, add their node to the neighbor list and continue to next.
    TC: O(V*E)
    SC: O(V)
optimization:
    build a clone graph, a cloned node with a emptylist, for each neighbor, recursively call cloneGraph for a cloned neighbor
    TC: O(V+E)
    SC: O(V)
 */
class Solution {
    Map<Node, Node> graph = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) return node;
        if(graph.containsKey(node)) return graph.get(node);

        Node clone = new Node(node.val, new ArrayList<>());

        graph.put(node, clone);
        for(Node neighbor : node.neighbors){
            Node clone_neighbor = cloneGraph(neighbor);
            clone.neighbors.add(clone_neighbor);
        }

        return clone;
    }
}