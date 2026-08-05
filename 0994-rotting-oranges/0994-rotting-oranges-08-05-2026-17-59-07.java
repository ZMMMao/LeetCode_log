/**
bfs 
count level as mins(return)
final check of any single 1
TC: O(m*n)
SC: O(m*n)
 */
class Solution {
    private final int[][] DIRC = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> levels = new ArrayDeque<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    levels.offer(new int[]{i, j});
                } else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;

        int mins = 0;

        while(!levels.isEmpty() && fresh > 0){
            int size = levels.size();
            for(int i = 0; i< size; i++){
                int[] cur = levels.poll();
                for(int[] d : DIRC){
                    int x = d[0] + cur[0];
                    int y = d[1] + cur[1];
                    if(x >=0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1){
                        grid[x][y] = 2;
                        fresh--;
                        levels.offer(new int[]{x, y});
                    }
                }
            }
            mins++;
        }
        return fresh == 0 ? mins : -1;
    }
}