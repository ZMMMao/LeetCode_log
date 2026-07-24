/**
circular array
traverse double size of array
TC: O(n)
SC: O(n)
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];

        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        for(int i = 0; i < 2*nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]){
                int k = stack.pop();
                res[k] = nums[i%nums.length];
            }
            stack.push(i%nums.length);
        }

        
        return res;
    }
}