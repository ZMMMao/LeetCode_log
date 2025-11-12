/**
input: int[] nums
output: int maxSum
input size: 1 - 10^5
input int range: -10^4 - 10^4
dp problem
memo[i] mentain the max at i
TC: O(n)
SC: O(n)
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        int maxSum = nums[0];
        memo[0] = nums[0];
        for(int i = 1; i < n; i++){
            memo[i] = Math.max(nums[i], memo[i - 1] + nums[i]);
            maxSum = Math.max(memo[i], maxSum);
        }
        return maxSum;
    }
}