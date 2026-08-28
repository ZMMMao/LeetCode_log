/**
restate:
    connection check
    return number of province
clarify:
    isConnected each array lenth is the number of cities?
    is there any self-connect?
approach:
    brute force:
    for each array of isConnected, dfs if [i][j] == 1, n visited for each i,j and total of n^2 points
    TC: O(n^3)
    SC: O(n)

    waste for revisiting on every subarray in isConnected

    better:
    build graph for connection mark
    bfs with a visited boolean array
    TC: O(n^2)
    SC: O(n)
 */
class Solution {
    public int findCircleNum(int[][] isConnected) {
        if(isConnected == null || isConnected.length == 0) return 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                bfs(i, isConnected, visited);
                count++;
            }
        }
        return count;
    }

    private void bfs(int i, int[][] isConnected, boolean[] visited){
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(i);
        visited[i] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int j = 0; j < isConnected.length; j++){
                if(visited[j]) continue;
                if(isConnected[curr][j] == 1){
                    visited[j] = true;
                    q.offer(j);
                }
            }
        }
    }
}
