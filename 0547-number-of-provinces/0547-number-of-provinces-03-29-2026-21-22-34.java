/**
DFS visited
OR
Union Find
1.path compression
2.union by rank
TC: O(n^2)
SC: O(n)
 */
class Solution {
    int[] parent, rank;
    public int findCircleNum(int[][] isConnected) {
        if(isConnected == null || isConnected.length == 0 || isConnected[0].length == 0) return -1;
        int n = isConnected.length;
        int count = n;
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(isConnected[i][j] == 1){
                    if(union(i, j)) count--;
                }
            }
        }

        return count;
    }

    private int find(int i){
        if(parent[i] != i){
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    private boolean union(int x, int y){
        int fx = find(x);
        int fy = find(y);
        if(fx == fy) return false;

        if(rank[fx] < rank[fy]) parent[fx] = fy;
        else if(rank[fx] > rank[fy]) parent[fy] = fx;
        else{
            parent[fx] = fy;
            rank[fy]++;
        }
        return true;
    }
}