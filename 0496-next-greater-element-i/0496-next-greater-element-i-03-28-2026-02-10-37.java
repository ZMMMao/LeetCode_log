/**
Algo: Monotonic Stack
Data Structure: Stack(monotonic decreasing, pop when next greater appears), 
                HashMap(K-V : num from nums2 - next greater number if exists)
TC: O(n), n = nums2.length
SC: O(n)

*/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[0]);
        for(int i = 1; i < nums2.length; i++){
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        for(int j = 0; j < nums1.length; j++){
            if(map.containsKey(nums1[j])){
                res[j] = map.get(nums1[j]);
            }
        }
        return res;
    }
}