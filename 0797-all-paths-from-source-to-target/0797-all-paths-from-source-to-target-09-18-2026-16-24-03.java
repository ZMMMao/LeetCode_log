/**
restate:
    directed, acyclic, node: n [0, n-1], edge: graph[i], input given as adjacency matrix
    asking for all path from 0 to n-1
clarify:
    always a solution?
approach:
        for every 0 go through the path until reach n-1 or deadend.
        TC: O(2^n * n)
        SC: O(n) each path's all stack is n
 */
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if(graph == null || graph.length == 0 || graph[0].length == 0) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        dfs(graph, 0, new ArrayList<>(), res);

        return res;
    }

    private void dfs(int[][] graph, int i, List<Integer> path, List<List<Integer>> res){
        path.add(i);

        if(i == graph.length - 1){
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        } 

        for(int j : graph[i]){
            dfs(graph, j, path, res);
        }

        path.removeLast();
    }
}