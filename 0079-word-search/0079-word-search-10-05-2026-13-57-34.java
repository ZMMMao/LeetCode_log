/**
restate:
    input: char[][] board, string word
    output: boolean, true if exists
    constraints: lowercase and uppercase English letters, m,n in [1, 6]

clarify:
    only English letters?
    if upper and lower case considered as same in a word?
    no re-use of letters?
    grid is square or rectangle

approach:
    approach:
    Try every cell as a start.
    dfs(i, j, idx): does word[idx..] start at cell (i, j)?
      - out of bounds, visited, or mismatch → false
      - mark visited, try 4 neighbors with idx + 1; any true → true
      - unmark before returning false, so other paths can use this cell
    idx == word.length → true

    TC: O(m*n*3^L)
    SC: O(L + m*n)
 */

 /**
 testcase: [[A, B, C, D], [E, E, F, G]], word = "BEE"
i = 0, j = 1, char = 'B', find first letter match 
    -> dfs(0, 1):
        pruning invalid -1 index;
        dfs(0, 0): 'A' -> return false;
        dfs(1, 1): 'E' -> "BE"
            dfs(1, 0) -> 'E' -> "BEE", found -> true, return true;
    return true;
 
 follow-up:
    space saving/ no visited
        in-place mark, '#'
    search pruning for large board?
        "Two pruning tricks: first, check letter frequencies, and if the board doesn't have enough of some letter, return false immediately. Second, if the first letter of the word is more common on the board than the last, search the reversed word, since starting from the rarer letter cuts down the number of starting points and branches."
  */
class Solution {
    private static final int[][] DIRC = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        if(board == null || word == null) return false;

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(i, j, 0, board, word, visited)) return true;
            }
        }
        return false;
    }
    private boolean dfs(int i, int j, int idx, char[][] board, String word, boolean[][] visited){
        if(idx == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if(visited[i][j] || word.charAt(idx) != board[i][j]) return false;

        visited[i][j] = true;

        for(int[] d : DIRC){
            int x = d[0] + i;
            int y = d[1] + j;
            if(dfs(x, y, idx+1, board, word, visited)){
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}