class Solution {
    private static final int[][] DIRS = {{1,0}, {-1,0}, {0, 1}, {0, -1}};

    private class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word;
    }
/**
approach: 
for each word, do a dfs to find if exist
if char[i][j] == word.charAt(0): dfs(i, j, 0, stringBuilder, res, visited, word, board)
dfs:
if k == word.length() res.add
 */
    public List<String> findWords(char[][] board, String[] words) {
        if(board == null || words == null) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++){
                int c = word.charAt(i) - 'a';
                if(node.children[c] == null) node.children[c] = new TrieNode();
                node = node.children[c];
            }
            node.word = word;
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(i,j, root, res, board);
            }
        }
        return res;
    }

    private void dfs(int i, int j, TrieNode root, List<String> res, char[][] board){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        char curr = board[i][j];
        if(curr == '#' || root.children[curr - 'a'] == null) return;

        TrieNode next = root.children[curr - 'a'];
        if(next.word != null){
            res.add(next.word);
            next.word = null;
        }

        board[i][j] = '#';
        for(int[] d : DIRS){
            int x = d[0] + i;
            int y = d[1] + j;
            dfs(x, y, next, res, board);
        }
        board[i][j] = curr;
    }
}