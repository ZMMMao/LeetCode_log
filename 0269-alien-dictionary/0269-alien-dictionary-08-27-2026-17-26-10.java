/**
1. restate: 
    return a string of unique letters in new order
    lexicographically increasing
2.clarify:
    only lowercase letters
    invalid return ""
3.approach:
    brute force:
    for result string, traverse list of strings and comparing each letter to find order
    if first letter different, add letter as their order
    if same prefix, add first difference
    words.length = n
    string.length() = m
    TC: (mn)
    SC: O(mn)

    need to check invalid order return ""

    optimization:
    build graph, add edge only first different
    TC: O(mn)
    SC: O(mn)
    
    (+12min)
 */
class Solution {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";

        Map<Character, List<Character>> graph = new HashMap<>();
        int[] indegree = new int[26];

        for(String word : words){
            for(char c : word.toCharArray()){
                if(graph.containsKey(c)) continue;
                graph.put(c, new ArrayList<>());
            }
        }
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < words.length - 1; i++){
            String curr = words[i];
            String nxt = words[i+1];
            for(int j = 0; j < curr.length();j++){
                if(j == nxt.length() && j < curr.length()) return "";
                if(j < nxt.length() && curr.charAt(j) == nxt.charAt(j)) continue;
                graph.get(curr.charAt(j)).add(nxt.charAt(j));
                indegree[nxt.charAt(j) - 'a']++;
                break;
            }
        }

        Deque<Character> queue = new ArrayDeque<>();
        for(char k : graph.keySet()){
            if(indegree[k - 'a'] == 0){
                queue.offer(k);
            }
        }

        while(!queue.isEmpty()){
            char q = queue.poll();
            res.append(q);
            for(char n : graph.get(q)){
                indegree[n - 'a']--;
                if(indegree[n - 'a'] == 0){
                    queue.offer(n);
                }
            }
        }

        return res.length() == graph.size() ? res.toString() : "";
    }
}