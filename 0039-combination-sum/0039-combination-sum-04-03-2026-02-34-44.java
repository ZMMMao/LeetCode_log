class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return new ArrayList<>();

        List<Integer> comb = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, target, candidates, comb, res);
        return res;
    }

    private void dfs(int start, int target, int[] candidates, List<Integer> comb, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(comb));
            return;
        }

        if(target < 0) return;

        for(int i = start; i < candidates.length; i++){
            comb.add(candidates[i]);
            dfs(i, target - candidates[i], candidates, comb, res);
            comb.removeLast();
        }
        
    }
}