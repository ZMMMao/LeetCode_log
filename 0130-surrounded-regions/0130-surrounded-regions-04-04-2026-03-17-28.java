/**
input:
    char[][]
    length:[1, 200]
    only 'X' and 'O'
output: 
    void
edge case: 
    null or single char board, return
approach:
    dfs, find all grid from each grid TC: O(m*n)^2
    exclude boundry 'O'
    first visit all boundry 'O' and mark visited
    then traverse and check any non-visited
    TC: O(m*n)
    SC: O(m*n)
 */
class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length <= 1) return;

        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; i++){
            if(board[i][0] == 'O') dfs(board, i, 0);
            if(board[i][cols - 1] == 'O') dfs(board, i, cols-1);
        }

        for(int j = 0; j < cols; j++){
            if(board[0][j] == 'O') dfs(board, 0, j);
            if(board[rows - 1][j] == 'O') dfs(board, rows-1, j);
        }
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }else if(board[r][c] == '#'){
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c){
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O') return;

        board[r][c] = '#';

        dfs(board, r - 1, c);
        dfs(board, r + 1, c);
        dfs(board, r, c+1);
        dfs(board, r, c-1);
    }
}