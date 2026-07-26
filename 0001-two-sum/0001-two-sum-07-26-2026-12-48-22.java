/**
return indices of two numbers, int[2]
hashmap num - index
TC: O(n)
SC: O(n)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            if(!map.containsKey(target - nums[i])){
                map.put(nums[i], i);
            }else{
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
        }

        return res;
    }
}