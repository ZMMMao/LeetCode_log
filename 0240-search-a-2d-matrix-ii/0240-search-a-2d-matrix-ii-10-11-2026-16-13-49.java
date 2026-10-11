/**
input: int[][] matrix, int target
output: boolean true if target is in the matrix
constraint: m,n in [1, 300], matrix[i][j] and target in [-10^9, 10^9]

clarify: any duplicates? If so, return any?

approach:
brute force:
    binary search each row, it's a time complexity of mlogn

optimal: find a monotonic point
start from top right corner
from int curr = matrix[0][n-1]
if target == curr return true
if target > curr, r++;
if target < curr, c--;
TC: O(m+n)
SC: O(1)
 */
/**
test case:
target = 5, from top-right -> left -> left -> left -> down -> found, true

target = -1, all the way left until break the loop -> false
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;

        int r = 0;
        int c = matrix[0].length - 1;
        while(r < matrix.length && c >= 0){
            int curr = matrix[r][c];
            if(curr == target) return true;
            if(curr > target)c--;
            else r++;
        }
        return false;
    }
}