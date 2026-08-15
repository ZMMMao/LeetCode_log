/**
multi source BFS
queue for each level, change to 2 and count time
recheck if any 1, return -1 // impossible
TC: O(m*n)
SC: O(m*n),
 */
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        Deque<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) queue.offer(new int[]{i, j});
            }
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i< size; i++){
                int[] curr = queue.poll();
                for(int[] d : dirs){
                    int x = d[0] + curr[0];
                    int y = d[1] + curr[1];
                    if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1){
                        queue.offer(new int[]{x, y});
                        grid[x][y] = 2;
                    }
                }
            }
            if(!queue.isEmpty()) count++;
        }

        for(int[] row : grid){
            for(int i : row){
                if(i == 1) return -1;
            }
        }
        return count;
    }
}
/**
dry run:



 */