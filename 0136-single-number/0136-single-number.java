/**
input:
    type: int[]
    length: [1, 3*10^4]
    nums[i]: [-3*10^4, 3*10^4]
output:
    int single
edge case:
    nums.length == 1 return nums[0]
    empty int[] return Integer.MIN_VALUE
approach:
    complexity requirement:
        TC: O(n)
        SC: O(1)
    brute force: 
        hashmap/set 
        TC: O(n)
        SC: O(n)
    optimal:
        XOR


 */
class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return Integer.MIN_VALUE;
        if(nums.length == 1) return nums[0];

        int res = 0;
        for(int n : nums){
            res ^= n;
        }

        return res;
    }
}