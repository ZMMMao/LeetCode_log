/*
Given: A 2D array of integers representing land and water.
Values of 0 represent water.  Values of 1 are land.
An "island" is a set of adjacent (N, S, E, or W) values = 1.
Your task: count the number of unique island shapes.

For example:
int[][] grid = {
    {1, 1, 0, 0, 0, 0, 0},
    {1, 0, 0, 0, 1, 1, 0},
    {1, 0, 0, 0, 0, 1, 0},
    {0, 0, 1, 1, 0, 0, 0},
    {0, 0, 1, 0, 0, 1, 1},
    {0, 0, 1, 0, 0, 1, 0}
};

There are four islands.

The islands in the top left, and bottom 3rd column are the same shape.

Expected return value:  3.
// 1, 1.  1, 1.  1, 1
// 1      1        1
// 1
*/
/**
constraint: m x n; m,n in [0, 10^6], no input modification
edge case:
[] return 0;

BFS: 
queue: scan the array, enqueue from first 1, mark visited
hashSet: store list of list of integer, 
a list of integer is the coordinate of (row - r, col - c) added during BFS search(r,c)
*/
/**
int[][] grid = {
    {1, 1, 0, 0, 0, 0, 0},
    {1, 0, 0, 0, 1, 1, 0},
    {1, 0, 0, 0, 0, 1, 0},
    {0, 0, 1, 1, 0, 0, 0},
    {0, 0, 1, 0, 0, 1, 1},
    {0, 0, 1, 0, 0, 1, 0}
};
expected = 3;

bfs(0, 0): visited: (0, 0); shape{0, 0},; enqueue: (0,1), (1,0)
    bfs(1,0): visited marked; shape: 0, 0, 1, 0; add (2, 0)
    bfs(0,1): visited marked; shape: 0, 0, 1, 0, 0, 1; 
    bfs(2,0): visited marked; shape: 0, 0, 1, 0, 0, 1, 2, 0

bfs(3, 2): visited; shape: 0, 0; enqueue (4,2) , (3, 3)
    bfs(4, 2): shape: 0, 0, 1, 0, enqueue (5, 2)
    bfs(3, 3): shape: 0，0， 1，0，0，1
    bfs(5, 2): shape: 0, 0, 1, 0, 0, 1, 2, 0


*/
class Solution {
    public int numDistinctIslands(int[][] grid) {
    if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        Set<List<Integer>> set = new HashSet<>();
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    List<Integer> shape = new ArrayList<>();
                    bfs(i, j, shape, grid, visited);
                    set.add(shape);
                }
            }
        }
        
        return set.size();
    }
    
    private void bfs(int r, int c, List<Integer> shape, int[][] grid, boolean[][] visited){
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            shape.add(curr[0] - r);
            shape.add(curr[1] - c);
            for(int[] d : dirs){
                int x = d[0] + curr[0];
                int y = d[1] + curr[1];
                if(x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1 && !visited[x][y]){
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
    }
}