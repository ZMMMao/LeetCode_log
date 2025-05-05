/**
Algo: linear sort, two pointers
Data Sturcture: array

Time: 

TC: O(n)
SC: O(1)
TestCase:
negative numbers
positive numbers
0
all duplicate number
large numbers
empty
duplicate at the second half
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