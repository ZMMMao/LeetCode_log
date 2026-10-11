/**
input: int[][] matrix, int target
output: boolean if found
constraint: m,n in [1, 100], matrix[i][j] and target in [-10^4, 10^4]

clarify:
each row is sorted and first integer of the row is smaller the previous row's last integer

approach:
simple scan for TC at O(mn)

binary search:
left = 0;
right = m*n - 1;
row = mid / n
col = mid % n
TC: O(log(mn))
SC: O(1)

test case:
for example 1, target = 3, 3x4 matrix
l = 0, r = 11, mid = 5, r = 1, c = 1 -> midNumber = 11 > 3
l = 0, right = 4, mid = 2, r = 0, c = 2 -> midNUmber = 5 > 3
l = 0, right = 1, mid = 0, midNumber = 1 < 3
l = 1, right = 1, mid = 1, midNumber = 3 -> return true
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int left = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int right = m*n - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target) return true;
            if(matrix[row][col] > target) right = mid-1;
            else left = mid+1;
        }
        return false;
    }
}