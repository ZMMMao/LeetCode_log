class Solution {
    public int rob(int[] nums) {
        /**
        DP optimized O(1) space
         */
        int n = nums.length;
        int[] max = new int[n];
        int f0 = 0;
        int f1 = 0;

        for(int num : nums){
            int newMax = Math.max(f1, f0 + num);
            f0 = f1;
            f1 = newMax;
        }
        return f1;
    }
}

/**
recursion + memo array
TC: O(n)
SC: O(n)

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
*/ 