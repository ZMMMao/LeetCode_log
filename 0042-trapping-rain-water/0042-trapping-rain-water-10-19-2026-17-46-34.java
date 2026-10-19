/**
input: int[] height
output: int 
constraint: height.length in [1, 2*10^4], height[i] in [0, 10^5]

clarify:
boundary doesn't count?

approach:
brute force:
max water at i = min(left_max, right_max) - height[i]

monotonic stack:
stack stores index, if peek() < h[i], pop and calculate area:
new peek() as left, h[i] as right and peek as mid;
water += min(left, right) - mid;

dry run:
h = [2, 0, 1, 3]

 */
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                int mid = stack.pop();
                if(stack.isEmpty()) break;
                int left = stack.peek();
                int h = Math.min(height[left], height[i]) - height[mid];
                int width = i - left - 1;
                res += h * width;
            }
            stack.push(i);
        }
        return res;
    }
}