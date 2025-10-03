class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, dfs(i, memo, nums));
        }
        return max;
    }

    public int dfs(int idx, int[] memo, int[] nums){
        if(memo[idx] > 0) return memo[idx];

        int res = 0;
        for(int j = 0; j < idx; j++){
            if(nums[j] < nums[idx]){
                res = Math.max(res, dfs(j, memo, nums));
            }
        }
        res++;
        return memo[idx] = res;
    }
        // int n = nums.length;
        // int[] memo = new int[n];
        // int max = 0;
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < i; j++){
        //         if(nums[j] < nums[i]){
        //             memo[i] = Math.max(memo[i], memo[j]);
        //         }
        //     }
        //     memo[i]++;
        //     max = Math.max(max, memo[i]);
        // }
        // return max;
    
}
/**
TC: O(n^2)
SC: O(n)

 */