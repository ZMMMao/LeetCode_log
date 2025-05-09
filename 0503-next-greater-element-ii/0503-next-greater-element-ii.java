/**
Algo: Monotonic decreasing stack
Data Structure: Stack, array
TC: O(n);
SC: O(n);

 */

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(res, -1);

        for(int i = 0; i < 2*n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i % n]){
                res[stack.pop()] = nums[i % n];
            }
            if(i < n){
                stack.push(i);
            }
        }
        return res;
    }
}