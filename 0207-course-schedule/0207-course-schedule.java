class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        int[] indegree = new int[numCourses];

        for(int[] edge : prerequisites){
            int from = edge[1];
            int to = edge[0];
            indegree[to]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int count = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            count++;
            for(int t : graph[cur]){
                indegree[t]--;
                if(indegree[t] == 0){
                    q.offer(t);
                }
            }
        }

        return count == numCourses;
    }

    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new LinkedList[numCourses];

        for(int i = 0; i < numCourses; i++){
            graph[i] = new LinkedList<>();
        }

        for(int[] edge : prerequisites){
            int to = edge[0];
            int from = edge[1];
            graph[from].add(to);
        }

        return graph;
    }
}