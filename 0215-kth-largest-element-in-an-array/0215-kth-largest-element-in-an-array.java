/**
Algo: min heap/PQ
Data Struc: min heap
TC: O(nlogk)
SC: O(k)
 */


class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < nums.length; i++){
            pq.offer(nums[i]);
            while(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}