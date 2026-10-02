/**
restate:
    input: int[], int target
    output: int[] of indices of the 2 numbers
    constraint: nums.length range in [2, 10^4]; nums[i] in [-10^9, 10^9]; target in integer range

clarify:
    if array is sorted?
    the answer always exists?
    use element only once
    any duplicate number?

approach:
    brute force: 
    for each number, traverse the whole array for the remaining
    TC: O(n^2)
    SC: O(1)

    optimal:
    use hashmap, mapping number to index
    TC: O(n)
    SC: O(n)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[2];

        Map<Integer, Integer> numToIdx = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int remain = target - nums[i];
            if(numToIdx.containsKey(remain)){
                return new int[]{i, numToIdx.get(remain)};
            }else{
                numToIdx.put(nums[i], i);
            }
        }

        return new int[2];
    }
}