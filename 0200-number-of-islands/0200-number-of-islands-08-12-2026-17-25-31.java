/**
1. restate:
input: m x n char[][]grid, '1' and '0'
output: int number of island
2. clarify:
Can this array be mutable?
char are only '1' and '0'
data size? m,n [1,300]
3. Approach:
brute force:
    for a '1', traverese all m by n, look for boundary ('0'), BFS check it's reachable from previous grid
    TC: O((mn)^2)
    SC: O(mn)
    wasted repeatedly check for every '1' connected
optimization:
    flood fill, change '1' to '0' as you visited
    TC: O(mn)
    SC: O(min(m,n))
 */
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private int[][] DIRC = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void bfs(char[][] grid, int i, int j){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = '0';
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int a = 0; a < size; a++){
                int[] curr = queue.poll();
                for(int[] d : DIRC){
                    int x = d[0] + curr[0];
                    int y = d[1] + curr[1];
                    if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1'){
                        grid[x][y] = '0';
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}
/**
dry run:
[["1"], ["1"]]
i   j   grid_value      queue                   count
0   0       1           [0,0]: 1-> 0               0
                        [1,0]: 1-> 0                 
                                                    1
1   1       0                                       1
return: count = 1
 
Complexity:
TC: O(m*n)
SC: O(min(m,n))
 
follow-up? 
1. no flipping
 boolean[][] visited
 if visited, continue; //skip 
2. why BFS?
BFS less overhead 
 */


