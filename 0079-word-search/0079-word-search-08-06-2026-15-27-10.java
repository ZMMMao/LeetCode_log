/**
dfs
track direction for new letter
visited[] mark no turn-backs
TC: O(3^l * m * n)
SC: O(m*n)
 */
class Solution {
    private boolean found = false;
    private int[][] DIRC = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;

        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){  
                dfs(board, i, j, 0, word, visited);
                if(found) return true;
            }
        }   
        return false;
    }

    private void dfs(char[][] board, int r, int c, int wordLen, String word, boolean[][] visited){
        if(wordLen == word.length()){
            found = true;
            return;
        }

        if(found) return;
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return;  
        if(visited[r][c]) return;
        if(board[r][c] != word.charAt(wordLen)) return;

        visited[r][c] = true;
     
        for(int[] d : DIRC){
            int x = r + d[0];
            int y = c + d[1];   
            dfs(board, x, y, wordLen+1, word, visited);
        }
        visited[r][c] = false;
    }
}