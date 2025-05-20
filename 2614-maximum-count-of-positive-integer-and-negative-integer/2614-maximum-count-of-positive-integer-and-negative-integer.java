/**
Algo: Binary Search
Data Structure: array
TC: O(logN)
SC: O(1)
 */
class Solution {
    public int maximumCount(int[] nums) {
        int neg = binarySearch(nums, 0);
        int pos = nums.length - binarySearch(nums, 1);
        return Math.max(neg, pos);
    }

    public int binarySearch(int[] nums, int target){
        int left = -1;
        int right = nums.length;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target) right = mid;
            else{left = mid;}
        }
        return right;
    }
}