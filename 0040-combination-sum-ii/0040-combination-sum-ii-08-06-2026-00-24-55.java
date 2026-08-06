/**
DFS
can re-use but no duplicate
helper function
target == 0, add result
for each element as a for loop
select or not, iterate through and target - new added num
TC: O(n*C(n, target/min))
SC: O(target / min)
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, res, new ArrayList<>());
        return res;        
    }

    private void dfs(int[] c, int start, int target, List<List<Integer>> res, List<Integer> path){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i < c.length; i++){
            if(i > start && c[i] == c[i-1]) continue;
            if(target < c[i]) break;
            path.add(c[i]);
            dfs(c, i+1, target - c[i], res, path);
            path.remove(path.size() - 1);
        }
    }
}