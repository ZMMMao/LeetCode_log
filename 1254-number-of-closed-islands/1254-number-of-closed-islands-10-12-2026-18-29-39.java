/**
if empty return 0;
length in [1, 10^6]
grid[i][j] in [0, 1]

edge case:
boundary not count
approach:
    BFS: 
    first scan the boundry and bfs, flip all 0 -> 1
    second scan will count and bfs
 */
class Solution {
    public int closedIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if((i == 0 || j == 0 || i == m - 1 || j == n - 1) && grid[i][j] == 0){
                    bfs(i, j, grid);
                }
            }
        }
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    count++;
                    bfs(i, j, grid);
                }
            }
        }
        return count;
    }

    private void bfs(int r, int c, int[][] grid){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});
        grid[r][c] = 1;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int[] d : dirs){
                int x = d[0] + curr[0];
                int y = d[1] + curr[1];
                if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 0){
                    queue.offer(new int[]{x, y});
                    grid[x][y] = 1;
                }
            }
        }
    }
}