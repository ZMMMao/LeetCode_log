/**
input: 
    type: int[][], int
    length: [1, 100]
    matrix[i][j], target: [-10^4, 10^4]
output:
    boolean
edge case/ use case:
    matrix == null return false
approach:
    brutal force: traverse
        TC: O(m*n), SC: O(1)
    optimal: binary search
        TC: O(log(mn)), SC: O(1)
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;

        if(matrix[m-1][n-1] < target) return false;

        int l = 0;
        int r = m*n - 1;
        while(l <= r){
            int mid = (l + r) /2;
            int row = mid / n; 
            int col = mid % n;
            if(matrix[row][col] == target) return true;
            if(matrix[row][col] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return false;
    }
}