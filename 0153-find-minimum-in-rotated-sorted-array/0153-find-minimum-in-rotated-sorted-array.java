/**
logn - binary search
siutation:
mid < left -> left
mid > left: left & right comparison
            if left > right -> right
 */
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int min = Math.min(nums[0], nums[n-1]);
        int l = 0;
        int r = n - 1;
        if(nums[l] < nums[r]) return nums[l];
        while(l <= r){
            int mid = l + (r - l)/2;
            min = Math.min(nums[mid], min);
            if(nums[mid] < nums[l]){
                r = mid - 1;
            }else{
                min = Math.min(nums[l], min);
                l = mid + 1;
            }
        }
        return min;
    }
}