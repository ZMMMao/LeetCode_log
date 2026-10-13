/**
input: int[][] grid, 0 for water, 1 for land
output: int max distance

constraint:
n x n, n in [1, 100], only 0 and 1

approach:
brute force:
global max
bfs: return currMax
if((i,j) == 1) return the dist
if == 0 add i,j and keep looking
TC: O(n^4)
SC: O(n^2)

optimal: start from the land and flip the water 0 -> 1

dry-run:
Input: grid = [
[1,1',1"],
[1,1',1"],
[1',1,1']]
Output: 2

queue: (0,0), (1,0), (2,1) ----- dist++ -> 1
-> (0,1), (1,1), (2,0), (2,2) ---- dist++ -> 2
-> (0,2), (1,2) ----- dist++ -> 3

return dist - 1 = 2
 */
class Solution {
    public int maxDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;

        int n = grid.length;
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i <n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if(queue.size() == 0 || queue.size() == n*n) return -1;

        int dist = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                for(int[] d : dirs){
                    int x = d[0] + curr[0];
                    int y = d[1] + curr[1];
                    if(x >= 0 && y >= 0 && x < n && y < n && grid[x][y] == 0){
                        grid[x][y] = 1;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            dist++;
        }
        return dist - 1;
    }
}