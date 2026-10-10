/**
input: int[][] grid
output: int min to have no fresh oranges
constraint:  m,n in [1, 10], grid[i][j] is 0, 1, 2 which 1 is fresh and 2 is rotten

clarify:

approach:
    multi source BFS:
    found a 2, enqueue, and do a level traverse to each direction if a 1, enqueue, min++
    re-scan the grid, if any 1 return -1;
    else return min

    TC: O(mn)
    SC: O(mn)

test case: [[2, 1, 0], [1, 0, 1]]

queue: [(0,0)]
min = 0;

queue: [(1,0), (0, 1)]
min = 1

queue is empty -> grid: [[2, 2, 0], [2, 0, 1]]
re-scan found a 1
return -1

follow-up:

 */
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;

        Deque<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) queue.add(new int[]{i, j});
                else if(grid[i][j] == 1) fresh++;
            }
        }
        int min = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            min++;
            for(int k = 0; k < size; k++){
                int[] curr = queue.poll();
                for(int[] d : dirs){
                    int x = d[0] + curr[0];
                    int y = d[1] + curr[1];
                    if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1){
                        grid[x][y] = 2;
                        fresh--;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }

        return fresh == 0 ? min : -1;
    }  
}