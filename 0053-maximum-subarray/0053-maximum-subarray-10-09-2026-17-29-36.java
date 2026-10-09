/**
input: int[]
output: int
constraint: array length in [1, 10^5], nums[i] in [-10^4, 10^4]

clarify:
only return the max value

approach:
traverse the whole array, for each nums[i], we record a global max and curr, to compare the current value
curr = max(nums[i], curr + nums[i])
max = max(max, curr)
return max 

TC: O(n)
SC: O(1)
 */
class Solution {
    public int maxSubArray(int[] nums) {
       if(nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int curr = nums[0];
       for(int i = 1; i < nums.length; i++){
            curr = Math.max(nums[i], curr + nums[i]);
            max = Math.max(max, curr);
       }
       return max;
    }
}