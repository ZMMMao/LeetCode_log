/**
dfs combinations
TC: O(n * 2^n)
SC: O(n)
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

        if(path.size() > k) return;

        for(int i = start; i <= n; i++){
            path.add(i);
            dfs(n, k, i+1, res, path);
            path.remove(path.size() - 1);
        }
    }
}