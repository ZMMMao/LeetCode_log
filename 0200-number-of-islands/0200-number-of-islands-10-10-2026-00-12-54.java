/**
approach:
dfs
flooding
flip 1 -> 0
TC: O(mn)
SC: O(mn)

dry run:
test case:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]

dfs(0, 0) -> grid[0][0] = '0'
-> dfs(1, 0), dfs(0, 1), dfs(1, 1) -> grid(1,0), grid(0, 1), grid(1, 1) -> '0'

count++ -> count = 1

dfs(2, 2) -> '0' -> count++ -> count = 2

dfs(3,3) -> '0'
-> dfs(4,3) -> '0' -> count++ -> count = 3

return 3;

 */
class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        int count = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == '1'){
                    dfs(r, c, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c, char[][] grid){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) return;
        if(grid[r][c] == '0') return;

        grid[r][c] = '0';
        for(int[] d : DIRS){
            int x = r + d[0];
            int y = c + d[1];
            dfs(x, y, grid);
        }
    }
}