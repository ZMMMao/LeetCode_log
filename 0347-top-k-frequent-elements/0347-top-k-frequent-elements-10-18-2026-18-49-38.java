/**
input: int[] nums, int k
output: int[]
constraint: nums.length in [1, 10^5], nums[i] in [-10^4, 10^4]

clarify:
guaranteed at least k unique numbers?
output order?

approach:
Map -> nums[i] - freq
minHeap for k most elements, the top is the k most frequent

dry-run:
nums = [1,1,1, 2, 3, 3, 4], k = 2
freq: {1:3, 2:1, 3:2, 4:1}
i = 1, i = 2, minHeap: {1, 2}
i = 3, minHeap: {1, 3, 2} -> size > k, poll 2 -> {1,3}
i = 4, minHeap: {1, 3}
res = [3, 1]
return res;
TC: O(nlogk)
SC: O(n+k),
what if two elements freq equal? offer larger number?
need a new if condition: if get(peek()) == get(i) && peek() < i -> poll peek() and offer i
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) return new int[0];

        Map<Integer, Integer> freq = new HashMap<>();
        for(int i : nums){
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));
        for(int i : freq.keySet()){
            minHeap.offer(i);
            if(minHeap.size() > k) minHeap.poll();
        }
        int[] res = new int[k];
        for(int i = 0; i < k ; i++){
            res[i] = minHeap.poll();
        }
        return res;
    }
}