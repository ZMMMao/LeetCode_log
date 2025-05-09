/**
Practice for merge sort and quick sort
1.merge sort:
TC: O(nlogn)
SC: O(n)


2. quick sort:
TC: O(nlogn)
SC: O(n)
 */

class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        //quickSort(nums, 0, n - 1);
        mergeSort(nums, 0, n - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right){
        if(left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right){
        int l = left;
        int r = mid + 1;
        int i = 0;
        int[] temp = new int[right - left + 1];

        while(l <= mid && r <= right){
            if(nums[l] <= nums[r]){
                temp[i++] = nums[l++];
            } else{
                temp[i++] = nums[r++];
            }
        }

        while(l <= mid){
            temp[i++] = nums[l++];
        }
        while(r <= right){
            temp[i++] = nums[r++];
        }

        for(int k = 0; k < temp.length; k++){
            nums[left + k] = temp[k];
        }
    }
    // public void quickSort(int[] nums, int start, int end){
    //     if(start >= end) return;
    //     int pivot = nums[(start + end) / 2];
    //     int left = start;
    //     int right = end;
    //     while(left <= right){
    //         while(left <= right && nums[left] < pivot) left++;
    //         while(left <= right && nums[right] > pivot) right--;
    //         if(left <= right){
    //             int temp = nums[left];
    //             nums[left] = nums[right];
    //             nums[right] = temp;
    //             right--;
    //             left++;
    //         }
    //     }
    //     quickSort(nums, start, right);
    //     quickSort(nums, left, end);
    // }
}