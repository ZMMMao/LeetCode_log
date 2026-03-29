class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for(String word : words){
            for(char w : word.toCharArray()){
                graph.putIfAbsent(w, new HashSet<Character>());
                indegree.putIfAbsent(w, 0);
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String cur = words[i];
            String nxt = words[i + 1];
            int len = Math.min(cur.length(), nxt.length());
            if(cur.length() > nxt.length() && cur.substring(0, nxt.length()).equals(nxt)) return "";
            for(int j = 0; j < len; j++){
                char a = cur.charAt(j);
                char b = nxt.charAt(j);
                if(a != b){
                    if(!graph.get(a).contains(b)){
                        graph.get(a).add(b);
                        indegree.put(b, indegree.get(b) + 1);
                    }
                    break;
                }
            }
        }

        Deque<Character> q = new ArrayDeque<>();
        for(char k : indegree.keySet()){
            if(indegree.get(k) == 0) q.offer(k);
        }

        StringBuilder dict = new StringBuilder();
        while(!q.isEmpty()){
            char ch = q.poll();
            dict.append(ch);
            for(char neighbor : graph.get(ch)){
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if(indegree.get(neighbor) == 0) q.offer(neighbor);
            }
        }

        return dict.length() == indegree.size() ? dict.toString() : "";
    }
}
/**
Graph with BFS
1. create graph with indegree
2. count/add indegree
3. BFS with queue for scanning the dict

TC: O(n + V + E);
SC: O(V + E);
 */