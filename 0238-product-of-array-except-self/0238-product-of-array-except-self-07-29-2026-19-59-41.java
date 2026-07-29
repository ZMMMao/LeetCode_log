/**
1 prefix array and 1 suffix array
TC: O(n)
SC: O(n)
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];

        int[] suffix = new int[nums.length];
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            prefix[i] = prefix[i-1] * nums[i];
        }

        suffix[nums.length-1] = nums[nums.length-1];
        for(int j = nums.length - 2; j >= 0; j--){
            suffix[j] = suffix[j+1] * nums[j];
        }
        
        int[] res = new int[nums.length];
        res[0] = suffix[1];
        res[nums.length - 1] = prefix[nums.length - 2];
        for(int i = 1; i<nums.length-1; i++){
            res[i] = prefix[i-1] * suffix[i+1];
        }
        return res;
    }
}