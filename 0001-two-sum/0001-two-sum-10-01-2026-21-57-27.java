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

/**
test case:
    empty input, []
    duplicates, [3, 3]
    regular case [2, 4, 5] find 6

dry-run:
test case: [2, 4, 5]
i = 0; nums[0] = 2, remain = 4, map = {} -> {{2, 0}}
i = 1; nums[1] = 4, remain = 2, containsKey at index = 0, return [0, 1] --- answer

follow-up:

 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[2];

        Map<Integer, Integer> numToIdx = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int remain = target - nums[i];
            if(numToIdx.containsKey(remain)){
                return new int[]{numToIdx.get(remain), i};
            }else{
                numToIdx.put(nums[i], i);
            }
        }

        return new int[2];
    }
}