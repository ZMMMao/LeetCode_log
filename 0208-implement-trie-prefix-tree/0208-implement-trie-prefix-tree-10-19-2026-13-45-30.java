 class Trie{
    private static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }
    
    private final TrieNode root;
    
    public Trie(){
        root = new TrieNode();
    }
    
    public void insert(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            if(node.children[i] == null) node.children[i] = new TrieNode();
            node = node.children[i];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word){
        TrieNode node = walk(word);
        return node != null && node.isEnd;
    }
    
    public boolean startsWith(String prefix){
        return walk(prefix) != null;
    }
    
    private TrieNode walk(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            node = node.children[i];
            if(node == null) return null;
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */