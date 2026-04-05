/**
permutation with duplicates
*/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        dfs(nums, path, res, visited);
        return res;
    }

    private void dfs(int[] nums, List<Integer> path, List<List<Integer>> res, boolean[] visited){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i< nums.length; i++){
            if(visited[i]) continue;
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, path, res, visited);
            path.removeLast();
            visited[i] = false;
        }
        
    }
}