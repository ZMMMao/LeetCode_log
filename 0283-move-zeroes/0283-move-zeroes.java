/**
Algo: linear sort, two pointer
Data Structure: array, two pointer

Time:

TC: O(n)
SC: O(1)

TestCase:
all 0
all non-0 integers
all negative
all positive
sorted
reverse sorted
large number
empty
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if(n == 0) return;

        int left = 0;
        for(int right = 0; right < n; right++){
            if(nums[right] != 0){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;               
            }
        }
    }
}