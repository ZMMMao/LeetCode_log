/**
monotonic stack
if next is higher/ right wall, calculate and pop
TC: O(n)
SC: O(n)
 */
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;

        Deque<Integer> stack = new ArrayDeque<>();
        int trap = 0;
        for(int i = 0; i<height.length; i++){
            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                int bottom = stack.pop();
                if(stack.isEmpty()) break;
                int left = stack.peek();
                int width = i - left - 1;
                int area = width * (Math.min(height[left], height[i]) - height[bottom]);
                trap += area;

            }
            stack.push(i);
        }

        return trap;
    }
}