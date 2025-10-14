class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;

        List<List<Integer>> eg = new ArrayList<>();
        for(int i = 0; i < n; i++) eg.add(new ArrayList<>());
        for(int[] e : edges){
            eg.get(e[0]).add(e[1]);
            eg.get(e[1]).add(e[0]);
        }

        boolean[] seen = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        seen[0] = true;
        int visited = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            visited++;
            for(int v : eg.get(curr)){
                if(!seen[v]){
                    seen[v] = true;
                    q.add(v);
                }
            }
        }
        return visited == n;
    }
}
/**
TC: O(n)
SC: O(n)
 */