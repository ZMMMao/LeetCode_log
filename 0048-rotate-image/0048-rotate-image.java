/**
input: 2D array
output void -> a 90-degree rotated 2D array
mirror reverse + 1D(row) reverse
TC: O(n^2)
SC: O(1)
 */
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int[] row : matrix){
            reverse(row);
        }
    }
    
    void reverse(int[] row){
        int n = row.length;
        int i = 0;
        int j = n - 1;
        while(j > i){
            int temp = row[i];
            row[i] = row [j];
            row[j] = temp;
            i++;
            j--;
        }
    }
}