/**
union find
TC: O(n)
SC: O(n)
 */
class Solution {
    int[] parent, rank;
    public int countComponents(int n, int[][] edges) {
        if(edges == null) return -1;

        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i<n; i++){
            parent[i] = i;
        }
        int count = n;
        for(int[] edge : edges){
            if(union(edge[0], edge[1])) count--;
        }
        return count;
    }

    private int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa == pb) return false;

        if(rank[pa] > rank[pb]){parent[pa] = pb;}
        else if(rank[pa] < rank[pb]) parent[pb] = pa;
        else{
            parent[pb] = pa;
            rank[pa]++;
        }
        return true;
    }
}