/**
input: int[] and int target
output: indices of 2 numbers
clarify:
nums[i] range?
sorted or not?
target range
only one solution?
no re-use
approach:
brute force: for nums[i], traverse the whole array to find another that can sum to target
    TC: O(n^2), SC O(1)
optimization:
    hashmap num[i] to index
    TC: O(n)
    SC: O(n)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[0];

        Map<Integer, Integer> index = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int remain = target - nums[i];
            if(index.containsKey(remain)) return new int[]{i, index.get(remain)};
            index.put(nums[i], i);
        }

        return new int[0];
    }
}