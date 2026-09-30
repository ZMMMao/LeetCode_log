/**
restate: 
    input: int[]
    output: a list of all possible subsets
    bc: no duplicate subsets, no order required
    range: array size 1-10, int range [-10, 10]

clarify: 
    empty set as a valid subset?
    is input sorted?

approach:
    backtracking method,
    start from the 0-index element, doing DFS on decisions, select / skip
    de-dup by skip the second same int
    TC: O(n*2^n + nlogn)
    SC: O(n)
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();

        traverse(0, new ArrayList<>(), nums, res);
        return res;
    }

    private void traverse(int index, List<Integer> set, int[] nums, List<List<Integer>> res){
        res.add(new ArrayList<>(set));

        for(int i = index; i < nums.length; i++){
            set.add(nums[i]);
            traverse(i+1, set, nums, res);
            set.removeLast();
        }

    }
}