/**
sum to target
can repeat but no duplicate sets
TC: O(n^(target/min))
SC: O(target/min)
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, res, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int start, int target, List<List<Integer>> res, List<Integer> path){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(candidates[i] > target) break;
            path.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], res, path);
            path.remove(path.size() - 1);
        }
    }
}