/**
input/output:
    - input type: int[] nums, int target
    - input len: [2, 10^4]
    - input range: [-10^9, 10^9]
    - output: int[] indices
edge case:
    - target out of range
    - null array
    return new int[0]
Approach:
    HashMap number - index
    target - num
    TC: O(n)
    SC: O(n)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        if(nums == null) return ans;
        Map<Integer, Integer> index = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int need = target - nums[i];
            if(index.containsKey(need)){
                ans[0] = index.get(need);
                ans[1] = i;
                return ans;
            }
            index.put(nums[i], i);
        }
        return ans;
    }
}
