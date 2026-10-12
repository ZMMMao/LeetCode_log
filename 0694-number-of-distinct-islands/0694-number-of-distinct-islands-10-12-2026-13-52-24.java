class Solution {
    public int numDistinctIslands(int[][] grid) {
    if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        Set<List<Integer>> set = new HashSet<>();
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    List<Integer> shape = new ArrayList<>();
                    bfs(i, j, shape, grid, visited);
                    set.add(shape);
                }
            }
        }
        
        return set.size();
    }
    
    private void bfs(int r, int c, List<Integer> shape, int[][] grid, boolean[][] visited){
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            shape.add(curr[0] - r);
            shape.add(curr[1] - c);
            for(int[] d : dirs){
                int x = d[0] + curr[0];
                int y = d[1] + curr[1];
                if(x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1 && !visited[x][y]){
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
    }
}