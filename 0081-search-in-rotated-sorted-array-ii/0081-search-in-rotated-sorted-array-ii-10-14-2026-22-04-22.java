/**
input: int[] nums, int target
output: boolean, true if found target
constraint: nums.length in [1, 5000], nums[i], target in [-10^4, 10^4]

clarify:
contains duplicates?

approach:
brute force: 
using a hashset to scan the array and lookup
TC: O(n)
SC: O(n)

optimal: 
[0, 1, 0, 0, 0]
binary search
need to find the sorted part
l, r, m
if m = target return 
if(l == mid) l++; continue;
if(l < mid){
    if l <= target < mid -> r = mid - 1;
    else l = mid + 1
}
else -> l > mid, r side sorted
    if mid < target <= r -> l = mid + 1;
    else r = mid - 1;
return -1 -> not found

TC: O(n)
SC: O(1)


 */
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;

        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target) return true;
            if(nums[left] == nums[mid]){
                left++; 
                continue;
            }
            if(nums[left] < nums[mid]){
                if(nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            }else{
                if(nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }
}