/**
node: word, V
edge: wordList as dictionary (list of edges), E
directed: yes
handed to me: wordList as a list of edges
Approach:
shortest sequence: BFS
TC: O(V + E)
SC: O(E)
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null || wordList == null) return 0;

        Set<String> list = new HashSet<>(wordList);
        if(!list.contains(endWord)) return 0;
        wordList.remove(beginWord);

        int step = 1;
        Set<String> visited = new HashSet<>();
        Deque<String> q = new ArrayDeque<>();
        visited.add(beginWord);
        q.offer(beginWord);
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i = 0; i < sz; i++){
                String curr = q.poll();
                char[] ch = curr.toCharArray();
                for(int j = 0; j < ch.length; j++){
                    char origin = ch[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == origin) continue;
                        ch[j] = c;
                        String newWord = new String(ch);
                        if(list.contains(newWord) && !visited.contains(newWord)){
                            if(newWord.equals(endWord)){
                                return step + 1;
                            }
                            q.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                    ch[j] = origin;
                }
            }
            step++;
        }
        return 0;
    }
}