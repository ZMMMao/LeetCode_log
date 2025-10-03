class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(nums, memo, n - 1);
    }

    public int dfs(int[] nums, int[] memo, int idx){
        if(idx < 0) return 0;
        if(memo[idx] != -1){
            return memo[idx];
        }
        return memo[idx] = Math.max(nums[idx] + dfs(nums, memo, idx - 2), dfs(nums, memo, idx - 1));
    }
}