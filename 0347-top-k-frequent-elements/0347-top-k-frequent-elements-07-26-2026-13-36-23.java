/**
minheap for topK most
TC: O(nlogk)
SC: O(n)
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        Map<Integer, Integer> count = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));

        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for(int n : count.keySet()){
            minHeap.offer(n);
            if(minHeap.size() > k) minHeap.poll();
        }
        int[] res = new int[minHeap.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }
}