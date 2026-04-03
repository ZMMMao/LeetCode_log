/**
input:
    type: int[] candidates, int target
    length: 1, 100
    [i]: [1, 50]
    target: [1, 30]
output:
    List<List<Integer>>
edge case:
    candidates == null return empty list
approach:
    dfs
    if target == 0 , add new comb, return
    if target <0 return;
    choice:
    1. select
    2. not select
    TC: O(n*2^n)
    SC: O(n)
*/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return new ArrayList<>();
        Arrays.sort(candidates);
        
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

        for(int i = start; i < candidates.length; i++){
            if(candidates[i] > target) break;
            if(i > start && candidates[i] == candidates[i - 1]) continue;
            comb.add(candidates[i]);
            dfs(i + 1, target - candidates[i], candidates, comb, res);
            comb.removeLast();
        }
    }
}