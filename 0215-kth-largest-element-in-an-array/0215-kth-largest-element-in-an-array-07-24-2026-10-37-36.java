/**
minheap, save k element
TC: O(nlogk)
SC: O(k)
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return Integer.MAX_VALUE;

        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            if(minheap.size() < k){
                minheap.offer(nums[i]);
            }else{
                if(minheap.peek() < nums[i]){
                    minheap.poll();
                    minheap.offer(nums[i]);
                }
            }
        }

        return minheap.poll();
    }
}