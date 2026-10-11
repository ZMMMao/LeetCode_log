/**
input: int[] nums, int target
output: a int[2]{}, starting and ending index of the target
constraint: nums.length in [0, 10^5], nums[i] and target in [-10^9, 10^9]

clarify:
non-decreasing -> duplicates

approach:
binary search: 
1. to find the ending position, need to find the first index of target+1
2. to find the starting position, need to get the first index of target

while(left <= right){
    mid = left + (right - left) / 2
    if(right >= target) right = mid - 1;
    else: left = mid + 1
}
return left;

TC: O(logn)
SC: O(1)


test case: [5, 7, 7, 7, 9], target = 7
in bs(7):
left = 0, right = 4, mid = 2 -> 7 >= 7, -> right = mid - 1

left = 0, right = 1, mid = 0 -> 5 < 7 -> left = mid + 1;
left = 1, right = 1, mid = 1 -> 7 >= 7 -> right = mid - 1 = 0 < left, break
return 1

in bs(8):
left = 0, right = 4, mid = 2 -> 7 < 8, -> left = mid + 1
left = 3, right = 4, mid = 3 -> 7 < 8 -> left = mid + 1
left = 4, right = 4, mid = 4 -> 9 > 8 -> right = mid - 1
left = 4 > right = 3, break
return 4

main return [1, 3]

 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        if(target < nums[0] || target > nums[nums.length - 1]) return new int[]{-1, -1};

        int last = bs(nums, target + 1);
        int first = bs(nums, target);

        return nums[first] == target ? new int[]{first, last - 1} : new int[]{-1, -1};
    }

    private int bs(int[] nums, int target){
        int left = 0 ;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/ 2;
            if(nums[mid] >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}