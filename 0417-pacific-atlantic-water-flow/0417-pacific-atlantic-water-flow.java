/**
island style problem
dfs
visited boolean
 */
class Solution {
    private static final int[][] DIRC = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] PacificVisited = new boolean[m][n];
        boolean[][] AtlanticVisited = new boolean[m][n];
        //Pacific
        for(int j = 0; j < n; j++){
            dfs(0, j, PacificVisited, heights);
        }
        for(int i = 1; i < m; i++){
            dfs(i, 0, PacificVisited, heights);
        }

        //Atlantic
        for(int j = 0; j < n; j++){
            dfs( m - 1, j, AtlanticVisited, heights);
        }
        for(int i = 0; i < m; i++){
            dfs(i, n-1, AtlanticVisited, heights);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(PacificVisited[i][j] && AtlanticVisited[i][j]){
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, boolean[][] visited, int[][] heights){
        if(visited[i][j]) return;

        visited[i][j] = true;
        for(int[] d : DIRC){
            int x = i + d[0], y = j + d[1];
            if(x >= 0 && x < heights.length && y >= 0 && y < heights[0].length && heights[x][y] >= heights[i][j]){
                dfs(x, y, visited, heights);
            }
        }
    }
}
/**
TC: O(mn)
SC: O(mn)
 */