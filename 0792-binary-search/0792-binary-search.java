/**
Algo: binary search
Data Structure: array
TC: O(logn)
SC: O(1)
*/

class Solution {
    public int search(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) right = mid;
            else{left = mid;}
        }
        return -1;
    }
}