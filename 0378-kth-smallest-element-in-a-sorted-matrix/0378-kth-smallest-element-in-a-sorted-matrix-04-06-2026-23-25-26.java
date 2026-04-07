/**
heap, kth smallest
TC: O(n^2logk)
SC: O(k)
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) return Integer.MIN_VALUE;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); 

        for(int[] row : matrix){
            for(int p : row){
                if(maxHeap.size() < k){
                    maxHeap.offer(p);
                }else{
                    if(maxHeap.peek() > p){
                        maxHeap.poll();
                        maxHeap.offer(p);
                    }
                }
            }
        } 

        return maxHeap.peek();
    }
}