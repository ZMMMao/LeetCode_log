/**
heap, kth smallest
TC: O(klogn)
SC: O(k)
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) return Integer.MIN_VALUE;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]); 

        for(int i = 0; i < matrix.length; i++){
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }

        for(int i = 0; i< k-1; i++){
            int[] curr = minHeap.poll();
            int row = curr[1], col = curr[2];
            if(col + 1 < matrix.length){
                minHeap.offer(new int[]{matrix[row][col+1], row, col+1});
            }
        }
        
        return minHeap.peek()[0];
    }
}