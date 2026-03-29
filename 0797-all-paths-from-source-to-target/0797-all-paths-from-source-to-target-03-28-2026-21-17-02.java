class Solution {
    List<List<Integer>> result = new LinkedList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        traversal(graph, 0);
        return result;    
    }

    private void traversal(int[][]graph, int s){

        path.addLast(s);

        if(s == graph.length - 1){
            result.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }

        for(int i : graph[s]){
            traversal(graph, i);
        }

        path.removeLast();
    }
}