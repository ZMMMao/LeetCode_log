/**
input: int[] height
output: int
constraint: height.length in [2, 10^5], height[i] in [0, 10^4]

clarify:
brute force: 
for each height, re-scan the array for max area, TC: O(n^2)

better:
two pointer: move the shorter pointer
calculate left - right * maxHeight area,
 
dry-run:
[1, 8, 7, 8, 1]
left = 0, right = 4, curr = 4 * 1 = 4; max = 4, height of left <= right, left++
left = 1, right = 4, curr = 3 * 1 = 3; max = 4, height of left > right, right--
left = 1, right = 3, curr = 2 * 8 = 16; max = 16, height of left <= right, left++
left = 2, right = 3, curr = 1 * 7 = 7; max = 16, height of left < right, left++
left = right, break
return max = 16
TC: O(n)
SC: O(1)
*/
class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(left < right){
            int curr = Math.min(height[left], height[right]) * (right - left);
            if(height[left] > height[right]) right--;
            else left++;
            max = Math.max(curr, max);
        }
        return max;
    }
}