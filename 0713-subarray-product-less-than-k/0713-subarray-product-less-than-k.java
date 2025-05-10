/**
Algo: linear sort - two pointer, sliding window
Data Structure: array
TC: O(n)
SC: O(1)
 */
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k < 1) return 0;
        int res = 0;
        int n = nums.length;
        int left = 0;
        int product = 1;
        for(int right = 0; right < n; right++){
            product *= nums[right];
            while(left <= right && product >= k){
                product /= nums[left];
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}