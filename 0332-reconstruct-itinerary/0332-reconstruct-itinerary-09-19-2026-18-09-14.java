/**
node: city
edge: ticket[i]
directed: Y
represent: a list of connection

restate: tickets[i] = [from, to] edge relationship
clarify: starts from JFK and lexcial order
approach:
    build a graph with hashmap, heap as the values (sort string as lexical order)



 */
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets == null || tickets.size() == 0) return new ArrayList<>();
        
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> ticket : tickets){
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<String>()).add(ticket.get(1));
        }

        List<String> result = new ArrayList<>();
        dfs(tickets, graph, "JFK", result);
        return result;
    }

    private void dfs(List<List<String>> tickets, Map<String, PriorityQueue<String>> graph, String from, List<String> result){
        PriorityQueue<String> dests = graph.get(from);
        while(dests != null && !dests.isEmpty()){
            dfs(tickets, graph, dests.poll(), result);
        }
        result.addFirst(from);
    }
}