/**
input: numCourses, int[][] prerequisites
output: boolean, true if can finish all
constraint: numCourses in [1, 2000], prerequisites in [0, 5000]

clarify: 
for int[a,b] : prerequisites, to take a, must finish b?
is that guaranteed to be only 1 prerequiste course a for taking b? prerequisite[i] == 2?

edge case: 
two course depends on each other -> a loop

approach:
directed graph, nodes are courses and prerequisites are edges, detect cycle
build graph connection and mark indegree
use queue for courses visit
if(indegree == 0) no prerequisite -> enqueue
after visit all, queue is empty
check if all indegree are 0, means we can finish all, return true
TC: O(V + E), V is numCourses, E is the length of prerequisites
SC: O(V + E)

dry-run:
2, [[0, 1], [1, 0]]
graph: (0, (1)), (1, (0))
indegree: [1, 1];
no indegree[i] == 0;
so queue is empty and indegree[0] == 1, return false;

valid case: 3, [1, 0], [2, 1]
graph: (0, (1)), (1, (2))
indegree [0, 1, 1]
queue: [0]
next[1], indegree[1]-- -> = 0, enqueue
queue: [1]
next: [2], indegree[2]-- -> = 0, enqueue
queue: [2]
next == null, queue is empty
break;

indegree[0, 0, 0]
return true;
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){graph[i] = new ArrayList<>();}
        int[] indegree = new int[numCourses];
        for(int[] edge : prerequisites){
            int to = edge[0];
            int from = edge[1];
            graph[from].add(to);
            indegree[to]++;  
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0) queue.offer(i);
        }
        int taken = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            taken++;
            for(int next : graph[curr]){
                indegree[next]--;
                if(indegree[next] == 0) queue.offer(next);
            }
        }
        return taken == numCourses;
    }
}