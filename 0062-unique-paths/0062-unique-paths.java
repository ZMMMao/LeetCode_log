class Solution {
    public int uniquePaths(int m, int n) {
        int[][] count = new int[m][n];
        return dfs(m - 1, n - 1, count);
    }

    private int dfs(int x, int y, int[][] memo){
        if(x < 0 || y < 0) return 0;
        if(x == 0 || y == 0) return 1;
        if(memo[x][y] != 0){
            return memo[x][y];
        }
        return memo[x][y] = dfs(x-1, y, memo) + dfs(x, y-1, memo);
    }
}
/**
TC: O(mn)
SC: O(mn)
 */