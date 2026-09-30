/**
restate:
    input: int[] candidates, int target
    output: list of unique combinations
    constraint: array length [1, 100], candidates[i] in [1, 50], target in [1,30]

clarify:
    re-use allowed? (no)
    input array has unique elements? (yes)
    order matters?
    input array can be sorted?

approach:
    sort ascending the input array
    backtracking: for each level, picking the next number of the combination from the start index onward
    - no re-use  so pick i and move to i+1
    - only pick from the start index onward, avoiding order dups
    - i > start && candidate[i-1] == cand[i] continue; remove duplicates input copy
    - if target < candidates[i] break (pruning)
    record the path if target == 0

    TC: O(2^n * T/min), nlogn of sorting cost is comparably ignored
    SC: O(T/min)
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        traverse(0, target, new ArrayList<>(), candidates, res);
        return res;
    }

    private void traverse(int start, int remain, List<Integer> path, int[] candidates, List<List<Integer>> res){
        if(remain == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i<candidates.length; i++){
            if(candidates[i] > remain) break;
            if(i > start && candidates[i-1] == candidates[i]) continue;
            path.add(candidates[i]);
            traverse(i + 1, remain - candidates[i], path, candidates, res);
            path.remove(path.size() - 1);
        }
    }
}