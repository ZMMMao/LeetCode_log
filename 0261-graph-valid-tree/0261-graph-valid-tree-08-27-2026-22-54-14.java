/**
restate:
    undirected edge
    if a valid tree
clarify:
    valid tree
    n = [1, 2000]
    edge = [0, 5000]
approach:
    brute force:
        read all edges, check if there is a cycle
        TC: O(V * E)
        SC: O(1)

        waste re-visit, use a graph with adjacency list for detecting cycle
    optimization:
        build graph and use a queue, enqueue when indegree = 0
        TC: O(V+E)
        SC: O(V)
*/
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i< n; i++) graph.add(new ArrayList<>());

        for(int[] edge : edges){
            int in = edge[0];
            int to = edge[1];
            graph.get(in).add(to);
            graph.get(to).add(in);
        }

        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        q.offer(0);
        visited[0] = true;
        int count = 1;

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int nxt : graph.get(curr)){
                if(visited[nxt]) continue;
                count++;
                q.offer(nxt);
                visited[nxt] = true;
            }
        }
        return count == n;
    }
}