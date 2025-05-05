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
        int n = nums.length;
        if(n == 0) return 0;
        int left = 1;
        for(int right = 1; right < n; right++){
            if(right > 0 && nums[right] == nums[right - 1]) continue;
            nums[left] = nums[right];
            left++;
        }
        return left;
    }
}