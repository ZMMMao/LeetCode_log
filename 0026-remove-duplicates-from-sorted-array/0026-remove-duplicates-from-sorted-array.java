/**
Algo: linear sort, two pointers
Data Sturcture: array

Time: 

TC:
SC: O(1)
TestCase:



 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int res = 0;
        int n = nums.length;
        if(n == 0) return res;
        int left = 0;
        for(int right = 0; right < n; right++){
            if(right > 0 && nums[right] == nums[right - 1]) continue;
            nums[left] = nums[right];
            left++;
            res++;
            
            
        }
        return res;
    }
}