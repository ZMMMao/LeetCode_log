/**
input/output:
    - input: int[] nums
    - input size: [2, 10^5]
    - input range: [-30, 30]
    - output: int[], can modify

edge cases:
    - null input: return new int[];
    - all duplicates 0;
    - product over int: use long type;

brute force: calculate the product every time, TC: n^2 , factorial
better: DP: prefix + surfix
TC: O(n)
SC: O(n) -> O(1), in-place modification
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        int[] suf = new int[n];
        suf[n-1] = 1;

        //calculate suffix array
        for(int i = n - 2; i>= 0; i--){
            suf[i] = suf[i + 1] * nums[i+1];
        }

        int prefix = 1;
        //calculate prefix and update suffix array
        for(int i = 0; i < n; i++){
            suf[i] *= prefix;
            prefix *= nums[i];
        }

        return suf;
    }
}