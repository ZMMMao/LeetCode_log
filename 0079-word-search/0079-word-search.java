/**
input char[][] board, String word
input size 1 <= m,n <= 6 ; 1 <= wordLen <= 15
output boolean if exist
TC: O(m*n*4wordLen)
SC: O(wordLen)
 */
class Solution {
    private static final int[][] DIRC = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        if(word.length() > m*n) return false;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i, j, 0, word, board)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int idx, String word, char[][] board){
        int m = board.length;
        int n = board[0].length;

        if(idx == word.length()){
            return true;
        }

        if(i < 0 || j < 0 || i >= m || j >= n) return false;
        
        if(board[i][j] != word.charAt(idx)) return false; 

        board[i][j] = (char) (-board[i][j]);
        for(int[] d : DIRC){
            int x = d[0] + i;
            int y = d[1] + j;
            if(dfs(x, y, idx+1, word, board)) return true;
        }
        board[i][j] = (char) (-board[i][j]);
        return false;
    }

}