/**
monostack
nums1 is the subset of nums2
distinct elements
map (nums2) currNum - nextGreaterIdx
TC: O(n)
SC: O(n)
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums2 == null || nums2.length == 0) return new int[0];

        Map<Integer, Integer> numToIdx = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < nums2.length; i++){
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                int key = stack.poll();
                numToIdx.put(key, i);
            }
            stack.offerFirst(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for(int j = 0; j<nums1.length; j++){
            if(numToIdx.get(nums1[j]) == null){
                res[j] = -1;
            }else{
                res[j] = nums2[numToIdx.get(nums1[j])];
            }
        }

        return res;
    }
}