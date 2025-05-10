/**
Algo: linear sort - sliding window
Data Structure: array
TC: O(n)
SC: O(1)
 */

class Solution {
    public long countSubarrays(int[] nums, long k) {
        long score = 0;
        long sum = 0;
        long res = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            score = sum * (right - left + 1);
            while(score >= k){
                sum -= nums[left];
                left++;
                score = sum * (right - left + 1); 
            }
            res += right - left + 1;
        }
        return res;
    }
}