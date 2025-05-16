/**
Algo: Binary Search
Data Structure: array, two pointer
TC: O(logn)
SC: O(n)
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, target);
        if(start == nums.length || nums[start] != target) return new int[]{-1, -1};
        int end = binarySearch(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    public int binarySearch(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/ 2;
            if(nums[mid] >= target){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return start;
    }
}