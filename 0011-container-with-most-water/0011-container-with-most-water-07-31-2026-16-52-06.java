/**
two pointer from tail and head
check max area by shorter height * index differ
TC: O(n)
SC: O(1)
 */
class Solution {
    public int maxArea(int[] height) {
       if(height == null || height.length <= 1) return 0;

        int max = 0;
        int left = 0;
        int n = height.length;
        int right = n - 1;

        while(left < right){
            int curr = Math.min(height[left], height[right]) * (right - left);

            if(left < right && height[left] <= height[right]){
                left++;
            }else{
                right--;
            }

            max = Math.max(curr, max);
        }

        return max;
    }
}