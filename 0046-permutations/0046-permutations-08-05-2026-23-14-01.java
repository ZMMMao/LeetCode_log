/**
permutations
TC: O(n*n!)
SC: O(n)
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, res, new ArrayList<>(), used);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, boolean[] used){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, res, path, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}