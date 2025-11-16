/**
input char[][] board, String[] words
input size m,n - [1, 12]; words - [1, 3*10^4];
input range: wordLen: 1 - 10
output: List<String> existWords
Trie + dfs
TC: O(total of words.length)
SC: O(total of words.length)
 */

class Solution {
    private static class Node{
            Node[] son = new Node[26];
            boolean end = false;
            String word = null;
    }

    private final Node root = new Node();
    private static final int[][] DIRC = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        Set<String> ans = new HashSet<>();

        for(String word : words){
            insert(word);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int idx = board[i][j] - 'a';
                if(root.son[idx] != null)
                dfs(i, j, ans, board, root.son[idx]);
            }
        }

        return new ArrayList<>(ans);
    }

    private void dfs(int i, int j, Set<String> ans, char[][] board, Node cur){
        if(cur.end && cur.word != null){
            ans.add(cur.word);
            cur.word = null;
        }

        char saved = board[i][j];
        board[i][j] = '#';

        int m = board.length;
        int n = board[0].length;

        for(int[] d : DIRC){
            int x = i + d[0];
            int y = j + d[1];
            if(x < 0 || y < 0 || x >= board.length || y >= board[0].length) continue;
            
            char ch = board[x][y];
            if(ch == '#') continue;
            int idx = ch - 'a';

            if(cur.son[idx] != null){
                dfs(x, y, ans, board, cur.son[idx]);
            }
        }

        board[i][j] = saved;
    }

    public void insert(String word){
        Node cur = root;
        for(char c : word.toCharArray()){
            c -= 'a';
            if(cur.son[c] == null){
                cur.son[c] = new Node();
            }
            cur = cur.son[c];
        }
        cur.end = true;
        cur.word = word;
    }
}