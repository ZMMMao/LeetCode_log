/**
shortest distance to each gate from empty room

BFS
if gate seed to queue
bfs with distance++; if INF, reset distance
if distance > current or -1, skip
TC: O(mn)
SC: O(mn)
 */
class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        Deque<int[]> queue = new ArrayDeque<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j< n; j++){
                if(rooms[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int dist = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            dist++;
            for(int i = 0; i< size; i++){
                int[] curr = queue.poll();
                for(int[] d : dirs){
                    int x = d[0] + curr[0];
                    int y = d[1] + curr[1];
                    if(x >= 0 && y >= 0 && x < m && y < n && rooms[x][y] > dist){
                        rooms[x][y] = dist;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}