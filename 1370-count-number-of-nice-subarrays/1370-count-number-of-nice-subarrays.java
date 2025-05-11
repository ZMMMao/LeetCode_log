/**
Algo: sliding window, 2 sliding tricks
Data Structure: pointer, array
TC: O(n)
SC: O(1)

 */
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int res = 0;
        int left1 = 0;
        int left2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] % 2 != 0) {
                count1++; 
                count2++;
            }
            while(count2 >= k){
                if(nums[left2] % 2 != 0) count2--;
                left2++;
            }
            while(count1 > k){
                if(nums[left1] % 2 != 0) count1--;
                left1++;
            }
            res += left2 - left1;
        }
        return res;
    }
}