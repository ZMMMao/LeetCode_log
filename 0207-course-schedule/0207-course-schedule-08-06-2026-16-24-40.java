/**
graph
hashmap map prerequisite - course
build graph
add indegree
bfs
TC: O(V+E)
SC: O(V+E)
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses];

        for(int[] edge : prerequisites){
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        int taken = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            taken++;
            for(int k : graph.get(cur)){
                indegree[k]--;
                if(indegree[k] == 0) q.offer(k);
            }
        }
        return taken == numCourses;
    }
}