/**
board[i][j] = "1" - "9" or "."
valid each row, column and 3x3 grid

Solution:
1. Brute Force: 3-pass hashset, traverse 3-3 grid + riw + col; TC: O(n^2), SC: O(n)
2. optimal: 1-pass hashmap
TC: O(n^2), 9*9 = 81 equals to O(1)
SC: O(n^2)
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0) return false;

        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][][] grid = new boolean[3][3][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j<9; j++){
                if(board[i][j] == '.') continue;
                int curr = board[i][j] - '1';
                if(row[i][curr] || col[j][curr] || grid[i/3][j/3][curr]) return false;
                row[i][curr] = col[j][curr] = grid[i/3][j/3][curr] = true;
            }
        }

        return true;
    }
}