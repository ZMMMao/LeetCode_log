/**
Algo: min-heap(PQ)
Data Structure: heap, array
TC: O(klogn)
SC: O(n)
 */

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if(k > n * n) return -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 0; i < Math.min(k, n); i++){
            pq.offer(new int[]{matrix[i][0], i, 0});
        }

        for(int i = 0; i < k - 1; i++){
            int[] curr = pq.poll();
            int row = curr[1];
            int col = curr[2];
            if(col < n - 1){
                pq.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }
        return pq.peek()[0];
    }
}