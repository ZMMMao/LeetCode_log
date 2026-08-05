/**
BFS, level order traversal - queue
for each 1, bfs traverse and flip 1 to 0
flooding
TC: O(m*n)
SC: O(min(m, n))
 */
class Solution {
    public int numIslands(char[][] grid) {
       if(grid == null || grid.length == 0) return -1;
        int m = grid.length; //row
        int n = grid[0].length; // col
        int res = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private final int[][] DIRC = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void bfs(char[][] grid, int r, int c){
        Queue<int[]> q = new ArrayDeque<>();
        grid[r][c] = '0';
        q.offer(new int[]{r, c});

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){    
                int[] cur = q.poll();
                for(int[] d : DIRC){
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if(x < grid.length && x >= 0 && y >= 0 && y < grid[0].length && grid[x][y] == '1'){
                        q.offer(new int[]{x, y});
                        grid[x][y] = '0';
                    }
                }
            }
        }
    }
}