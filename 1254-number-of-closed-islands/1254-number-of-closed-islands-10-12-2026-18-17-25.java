class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;

        for(int i = 0; i < n; i++){
            dfs(grid, i, 0);
            dfs(grid, i, m-1);
        }

        for(int j = 0; j < m; j++){
            dfs(grid, 0, j);
            dfs(grid, n-1, j);
        }

        for(int i = 1; i < n - 1; i++){
            for(int j = 1; j < m - 1; j++){
                if(grid[i][j] == 0){
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    void dfs(int[][] grid, int i, int j){
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int n = grid.length;
        int m = grid[0].length;

        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 1) return;

        grid[i][j] = 1;

        for(int[] d : dir){
            int x = d[0] + i;
            int y = d[1] + j;
            dfs(grid, x, y);
        }
    }
}