/**
input: int[] nums, and int target
output: int[], indices of two numbers that sum to target
constraint: integer range

clarify:
nums[i] and target in integer range?
duplicates?
guaranteed result? if not return -1?
sorted?
return indices order?
negative numbers?

approach:
brute force:
nested loop scan the array, TC: O(n^2), SC O(1)

better:
Map<Integer, Integer> stores (nums[i], i), return currIndex and i
if not found return -1;
TC: O(n), SC: O(n)

dry-run:
[-1, 1, 0], target -1 
i = 0, remain = 0, map: (-1, 0)
i = 1, remain = -2, map:(-1, 0), (1, 1)
i = 2, remain = -1, map found (-1, 0) -> return [0, 2]

int[] twoSum(int[] nums, int target): return the indices of two numbers that sum to target. O(n), single pass.
*/
    
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIdx = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            int remain = target - nums[i];
            if(numToIdx.containsKey(remain)){
                return new int[]{numToIdx.get(remain), i};
            }
            numToIdx.put(nums[i], i);
            
        }
        return new int[]{-1, -1};
    }
}