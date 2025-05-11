/**
Algo: linear sort - sliding window, atmost 2 sliding windows trick
Data Structure: array, pointer
TC: O(n);
SC: O(1);

 */
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        int left1 = 0;
        int left2 = 0;
        int sum1 = 0; // <= goal
        int sum2 = 0; // < goal
        for(int right = 0; right < nums.length; right++){
            sum1 += nums[right];
            sum2 += nums[right];
            while(left1 <= right && sum1 > goal){
                sum1 -= nums[left1];
                left1++;
            }
            while(left2 <= right && sum2 >= goal){
                sum2 -= nums[left2];
                left2++;
            }
            res += left2 - left1;
        }
        return res;
    }
}