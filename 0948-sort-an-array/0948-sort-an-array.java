/**
Practice for merge sort and quick sort
1.merge sort:
TC:
SC:


2. quick sort:
TC: O(nlogn)
SC: O(n)
 */

class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n - 1);
        //mergeSort(nums, 0, n - 1);
        return nums;
    }

    public void quickSort(int[] nums, int start, int end){
        if(start >= end) return;
        int pivot = nums[(start + end) / 2];
        int left = start;
        int right = end;
        while(left <= right){
            while(left <= right && nums[left] < pivot) left++;
            while(left <= right && nums[right] > pivot) right--;
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
                left++;
            }
        }
        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }
}