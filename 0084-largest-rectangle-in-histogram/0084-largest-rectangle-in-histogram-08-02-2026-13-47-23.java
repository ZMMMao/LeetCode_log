/**
monotonic stack (increasing), push all taller bar in and pop up if a shorter bar comes
TC: O(n)
SC: O(n)
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return -1;

        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        int n = heights.length;
        for(int i = 0; i <= n; i++){
            while(!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])){
                int idx = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, heights[idx] * width);
            }
            stack.push(i);
        }

        return max;
    }
}