/**
two pointer
triangles, 2 edge sum greater than third edge
TC: O(n^2)
SC: O(1)
fixed from the bigger side
 */
class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);

        int n = nums.length;
        int count = 0;

        for (int i = n-1; i >= 2; i--) {
            int left = 0;
            int right = i-1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]){
                    count += right - left;
                    right--;
                }else{
                    left++;
                }
                
            }
        }
        return count;
    }

}