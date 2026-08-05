/**
subset
no duplicate
dfs select or not-select
TC: O(n * 2^n)
SC: O(n)
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int i, List<List<Integer>> res, List<Integer> path){
        if(i == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[i]);
        dfs(nums, i+1, res, path);
        path.removeLast();
        
        dfs(nums, i+1, res, path);
    }
}