/**
input: int[] nums, int target
output: int index or -1 not in the nums
constraint: nums.length in [1, 5000], nums[i] and target in [-10^4, 10^4]

clarify: 
original ascending array

approach:
binary search
while left < right
if(mid == target)  return mid;

compare which part is sorted
}
 */
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            int curr = nums[mid];
            if(curr == target) return mid;
            
            if(nums[left] <= curr){
                if(nums[left] <= target && target < curr) right = mid - 1;
                else{left = mid + 1;}
            }else{
                if(nums[right] >= target && target > curr) left = mid + 1;
                else{right = mid - 1;}
            }
        }
        return -1;
    }
}