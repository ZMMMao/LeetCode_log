/**
union find
path compression
TC: O(n)
SC: O(n)
 */
class Solution {
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for(int[] edge : edges){
            uf.union(edge[0], edge[1]);
        }
        return uf.count();
    }
}

class UF{
    private int count;
    private int[] parent;

    public UF(int n){
        count = n;
        parent = new int[n];
        for(int i = 0; i<n; i++){
            parent[i] = i;
        }
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) return;

        parent[rootQ] = rootP;
        count--;
    }

    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean connected(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public int count(){
        return count;
    }
}