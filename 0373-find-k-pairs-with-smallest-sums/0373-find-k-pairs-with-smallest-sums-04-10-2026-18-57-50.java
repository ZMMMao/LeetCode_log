/**
input: 2 sorted arrays
output: k pairs of (u, v) with a smallest sum
TC: O(klogk)
SC: O(k)
 */
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) 
            return new ArrayList<>();

        int n = nums1.length, m = nums2.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> pairs = new ArrayList<>();
        
        for(int i = 0; i < Math.min(k, n); i++){
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while(k > 0 && !minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int i = curr[1];
            int j = curr[2];
            pairs.add(Arrays.asList(nums1[i], nums2[j]));

            if(j < m-1){
                minHeap.offer(new int[]{nums1[i] + nums2[j+1], i, j+1});
            }
            k--;
        }

        return pairs;
    }
}