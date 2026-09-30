/**
restate:
    input: int[], may contain dups
    output: power set, no duplicates
    constraint: 1 <= n <= 10, nums[i] in [-10, 10]

clarify:
    Is the empty set a valid set?
    array is sorted or not? 
    Can it be sorted? (order matters)
    output order matters?

Approach:
    first sort the array, so dups are adjacent
    bbacktracking: traverse with DFS,
    at index i, select or skip
    de-dup: skip the second and after same values
    select: add nums[i] to the path, traverse i+1, remove nums[i] after
    skip: i++, not selecting nums[i]

    TC: O(n*2^n), n for each path copy and 2^n for a full traverse of this decision tree
    SC: O(n) for recursion stack and path, excluding output cost
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        traverse(0, new ArrayList<>(), nums, res);
        return res;
    }

    private void traverse(int index, List<Integer> path, int[] nums, List<List<Integer>> res){
        res.add(new ArrayList<>(path));

        for(int i = index; i<nums.length; i++){
            if(i > index && nums[i-1] == nums[i]) continue;
            path.add(nums[i]);
            traverse(i+1, path, nums, res);
            path.removeLast();
        }
    }
}