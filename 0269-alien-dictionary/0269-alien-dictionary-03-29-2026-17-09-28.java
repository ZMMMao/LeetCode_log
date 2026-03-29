/**
indegree + bfs
if indegree[c] = 0, add to queue


 */
class Solution {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";

        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for(String word : words){
            for(char c : word.toCharArray()){
                indegree.putIfAbsent(c, 0);
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        for(int i = 0; i<words.length - 1; i++){
            String prev = words[i];
            String curr = words[i+1];
            int minLen = Math.min(prev.length(), curr.length());

            if(prev.length() > curr.length() && prev.startsWith(curr)) return "";

            for(int j = 0; j<minLen; j++){
                char from = prev.charAt(j);
                char to = curr.charAt(j);
                if(from != to){
                    if(!graph.get(from).contains(to)){
                        graph.get(from).add(to);
                        indegree.put(to, indegree.get(to) + 1);
                    }
                    break;
                }
            }
        }

        Deque<Character> q = new ArrayDeque<>();
        for(char c : indegree.keySet()){
            if(indegree.get(c) == 0) q.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char c = q.poll();
            sb.append(c);
            for(char neighbor : graph.get(c)){
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if(indegree.get(neighbor) == 0) q.offer(neighbor);
            }
        }

        
        if(sb.length() != indegree.size()) return "";
        return sb.toString();
    }
}