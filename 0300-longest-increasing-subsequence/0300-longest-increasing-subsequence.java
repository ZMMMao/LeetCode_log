class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    memo[i] = Math.max(memo[i], memo[j]);
                }
            }
            memo[i]++;
            max = Math.max(max, memo[i]);
        }
        return max;
    }
}
/**
TC: O(n^2)
SC: O(n)

 */