/**
Algo: min-heap
Data Struc: heap/PQ, list, array
TC: O(klogk)
SC: O(k)
 */
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new LinkedList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        for(int i = 0; i < Math.min(k, nums1.length); i++){
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        for(int j = 0; j < k; j++){
            int[] curr = pq.poll();
            int nxt = curr[2] + 1;
            if(nxt < nums2.length){
                pq.offer(new int[]{curr[0], nums2[nxt], nxt});
            }
            List<Integer> pair = new LinkedList<>();
            pair.add(curr[0]);
            pair.add(curr[1]);
            res.add(pair);
        }
        return res;
    }
}