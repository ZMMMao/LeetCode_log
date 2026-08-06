/**
dfs combinations
TC: O(k * C(n, k))
SC: O(k)
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if(n < k) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 1, res, new ArrayList<>());
        return res;
    }

    private void dfs(int n, int k, int start, List<List<Integer>> res, List<Integer> path){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i <= n - (k - path.size()) + 1; i++){
            path.add(i);
            dfs(n, k, i+1, res, path);
            path.remove(path.size() - 1);
        }
    }
}