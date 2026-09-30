/**
restate:
    input: distinct int[] and a target int
    output: list of unique combination that sum to target
    constraint: n range [1,30], candidates[i] in [2, 40], target in [1, 40]

clarify:
    reuse allowed?
    elements in int[] are distinct
    order of res matter?

approach:
    sort the array ascendingly
    backtracking: dfs traverse the decision tree of select or skip
    add path if target == 0 then return OR if i == n || target < nums[i], return
    select: add nums[i] to path, traverse with (target - nums[i], i+1)
    skip: traverse (target, i+1)

    TC: O(n*2^n), sorting nlogn can be ignored in this case
    SC: O(n) for recursion stack and path recording, excluding the output cost
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        traverse(0, new ArrayList<>(), target, candidates, res);
        return res;
    }

    private void traverse(int start, List<Integer> path, int target, int[] candidates, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i < candidates.length; i++){
            if(candidates[i] > target) break;
            path.add(candidates[i]);
            traverse(i, path, target - candidates[i], candidates, res);
            path.removeLast();
        }
    }

}