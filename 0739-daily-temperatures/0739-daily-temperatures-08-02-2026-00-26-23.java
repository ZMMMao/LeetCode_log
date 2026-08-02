/**
answer[i] is the number of day wait for next higher
stack temp if higher pop() -> push higher
TC: O(n)
SC: O(n)
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) return new int[0];

        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];

       for(int i = 0; i < temperatures.length; i++){
            int curr = temperatures[i];
            while(!stack.isEmpty() && temperatures[stack.peek()] < curr){
                int prev = stack.pop();
                res[prev] = i - prev; 
            }
            stack.push(i);
        }

        return res;
    }
}