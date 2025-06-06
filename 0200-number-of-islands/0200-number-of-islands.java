class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    void dfs(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;

        if(i >= m || j >= n || i < 0 || j < 0){
            return;
        }

        if(grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';

        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
    }
}