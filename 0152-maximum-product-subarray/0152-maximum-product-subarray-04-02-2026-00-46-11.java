/**
input:
    type: int[]
    length: 1, 2*10^4
    nums[i]: [-10, 10]
    subarray: contiguous non-empty sequence
output:
    int product
edge case:
    len = 1: return nums[0]
approach:
    brute force: 
        count every possible subarrays
        2 for loops
        TC: O(n^2)
        SC: O(1)
    optimal:
        dp, maintain a max and min array (negative best) for finding largest product
        TC: O(n)
        SC: O(n)
 */
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int n = nums.length;

        int[] min = new int[n];
        int[] max = new int[n];
        min[0] = nums[0];
        max[0] = nums[0];
        int maxP = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            min[i] = Math.min(Math.min(min[i - 1] * nums[i], nums[i]), max[i - 1] * nums[i]);
            max[i] = Math.max(Math.max(min[i - 1] * nums[i], nums[i]), max[i - 1] * nums[i]);
        }

        for (int i = 0; i < n; i++) {
            maxP = Math.max(maxP, max[i]);
        }

        return maxP;
    }
}