/**
DFS graph
TC: O(n)
SC: O(n)
 */
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if(graph == null || graph.length == 0 || graph[0].length == 0) return new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        

        dfs(0, graph, path, res);
        return res;
    }

    private void dfs(int i, int[][] graph, List<Integer> path, List<List<Integer>> res){
        path.add(i);

        if(i == graph.length - 1){
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }

        for(int neighbor : graph[i]){
            dfs(neighbor, graph, path, res);
        }
        path.removeLast();
    }
}