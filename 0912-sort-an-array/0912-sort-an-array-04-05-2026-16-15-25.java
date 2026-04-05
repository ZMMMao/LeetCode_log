/**
merge sort version
post-order binary tree
TC: O(nlogn)
SC: O(n)
 */
class Solution {
    private static int[] temp;

    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];

        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right){
        if(left >= right) return;

        int mid = left + (right - left)/2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right){
        for(int i = left; i <= right; i++){
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid+1;
        for(int k = left; k <= right; k++){
            if(j == right + 1){
                nums[k] = temp[i++];
            }else if(i == mid + 1){
                nums[k] = temp[j++];
            }else if(temp[i] > temp[j]){
                nums[k] = temp[j++];
            }else{
                nums[k] = temp[i++];
            }
        }
    }

}