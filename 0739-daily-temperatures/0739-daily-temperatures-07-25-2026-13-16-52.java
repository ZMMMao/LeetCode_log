/**
an array of index difference from curr to next higher num
monostack
return array of currIdx - nextHigherIdx
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) return new int[0];

        int[] res = new int[temperatures.length];
        Arrays.fill(res, 0);
        
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i< temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int curr = stack.pop();
                res[curr] = i - curr;
            }
            
            stack.push(i);
        }

        return res;
    }
}