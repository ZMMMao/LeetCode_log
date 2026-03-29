/**
lexical order
TC: O(ElogE)
SC: O(E)

 */
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets == null) return new ArrayList<>();

        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> ticket: tickets){
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>())
                 .add(ticket.get(1));
        }

        List<String> res = new ArrayList<>();
        dfs(graph, res, "JFK");
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> graph, List<String> res, String begin){
        PriorityQueue<String> destination = graph.get(begin);
        while(destination != null && !destination.isEmpty()){
            dfs(graph, res, destination.poll());
        }
        res.addFirst(begin);
    }
}