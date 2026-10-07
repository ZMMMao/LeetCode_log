/**
input: char[][] board
output: boolean valid
constraint: char in 1-9 and '.'
board is 9 x 9

clarify: 
char board, 
row, column and 3x3 sub-box no dups

approach:
use seen boolean[][] for check valid, x/3, y/3 check valid sub-box
traverse the whole board

TC: O(n^2)
SC: O(n^2)
n is fixed 9, so actually it's constant complexity.
 */
/**
how to dry run: a sub-box

 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][][] box = new boolean[3][3][9];
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                char ch = board[r][c];
                if(ch == '.') continue;
                int curr = ch - '1';

                if(row[r][curr] || col[c][curr] || box[r/3][c/3][curr]) return false;
                row[r][curr] = true;
                col[c][curr] = true;
                box[r/3][c/3][curr] = true;
            }
        }
        return true;
    }
}