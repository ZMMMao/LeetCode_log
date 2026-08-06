/**
contain duplicates, all subsets
dfs for loop template
TC: O(n * 2^n)
SC: O(n)
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int idx, List<List<Integer>> res, List<Integer> path){
        res.add(new ArrayList<>(path));

        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            dfs(nums, i+1, res, path);
            path.remove(path.size() - 1);
        }
    }
}