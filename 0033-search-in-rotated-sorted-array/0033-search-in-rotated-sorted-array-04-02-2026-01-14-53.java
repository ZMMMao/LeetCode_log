/**
input:
    type: int[], int
    array length: 1, 5000
    nums[i]: -10^4, 10^4
output：
    int index
edge case:
    nums is empty / target not exist, return -1
approach:
    brute force:
        traversal, TC: O(n)
    optimal:
        binary search:
        find first half sorted or second half sorted
        
            if nums[mid] == target return mid
            if nums[mid] > target{
                if(target > nums[0]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                // nums[mid] < target
                left = mid + 1;
            }
        return nums[left] == target ? left : -1
*/
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[left]){
                if(target < nums[mid] && target >= nums[left]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                //nums[mid] < nums[left], right half sorted
                if(target <= nums[right] && target > nums[mid]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}