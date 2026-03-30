/**
two pointer from left and right
if right == 0 swap with left, left++
if left == 2 swap with right, right--
TC: O(n)
SC: O(1)
 */
class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int left = 0;
        int mid = 0;
        int right = nums.length - 1;
        while(mid <= right){
            if(nums[mid] == 0){
                swap(nums, left, mid);
                left++;
                mid++;
            }else if(nums[mid] == 2){
                swap(nums, right, mid);
                right--;
            }else{
                mid++;
            }
        }
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
        return;
    }
}