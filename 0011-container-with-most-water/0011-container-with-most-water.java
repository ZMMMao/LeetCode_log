class Solution {
    /**
    two pointer
     */
    public int maxArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        int left = 0;
        int right = height.length - 1;
        int best = 0;
        while(left < right){
            int curr = Math.min(height[left], height[right]) * (right - left);
            best = Math.max(best, curr);
            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }
        }
        return best;
    }
}
/**
TC: O(n)
SC: O(1)
 */