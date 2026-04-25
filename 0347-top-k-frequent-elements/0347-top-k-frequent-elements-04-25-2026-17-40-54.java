/**
input: int[] nums, int k
output: int[], k most freq element
edge case: k == 0 || nums == null, return empty array
approach: 
heap + map (counting)
TC: O(nlogk)
SC: O(n)
 */

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == 0 || nums == null || nums.length == 0) return new int[0];

        Map<Integer, Integer> count = new HashMap<>();
        //minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));

        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for(int n : count.keySet()){
            if(minHeap.size() >= k){
                int min = minHeap.peek();
                if(count.get(min) < count.get(n)){
                    minHeap.poll();
                    minHeap.offer(n);
                }
            }else{
                minHeap.offer(n);
            }
        }

        int[] res = new int[k];
        for(int i = 0; i<k; i++){
            res[i] = minHeap.poll();
        }
        return res;
    }
}