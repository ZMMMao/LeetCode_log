/**
restate: find the kth largest element
clarify: must exist?
approach: 
    brute force: sort + count for k. 
    TC: O(nlogn + k)
    SC: O(1)
    cons: change the array's order and not fast enough
    
    optimize: minHeap with k elements
    TC: O(nlogk)
    SC: O(k)
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return -1;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int n : nums){
            minHeap.offer(n);
            while(minHeap.size() > k) minHeap.poll();
        }

        return minHeap.poll();
    }
}