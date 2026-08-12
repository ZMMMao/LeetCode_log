/**
1.restate:
    numCourses, prerequisites int[][], [[a,b]], take b before a
    return true;
2. clarify
a[1] is prerequest of a[0]?
courses are integers?
3. Approach:
brute force:
for each course, scan the pre[][] and check if it can take
TC: O(V*E), V for course, E for scan pre[][]
SC: O(V)
optimzation:
    build a graph(V, E) , start with indegree == 0,  BFS traverse, add can-take courses
    TC: O(V + E) for build and traverse the whole graph
    SC: O(V + E)
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            graph.put(i, new ArrayList<>());
        }
        int[] indegree = new int[numCourses];

        for(int[] pre : prerequisites){
            int from = pre[1];
            int to = pre[0];
            graph.get(from).add(to);
            indegree[to]++;
        }
        int count = 0;

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) {queue.offer(i); count++;}
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int next : graph.get(curr)){
                indegree[next]--;
                if(indegree[next] == 0) {queue.offer(next); count++;}
            }
        }

        return count == numCourses;
    }
}
/**
dry run:
courses = 2, prerequisites = [[1, 0]]
graph:(0, 1)

queue           indegree                count
0 -> get(1)        0,1 -> 0,0            1 -> 2
1 -> empty list, end
return: count == courses, 2== 2 -> true;

Complexity:
TC: O(V + E), V is numCourses, E is the number of prereq.length (relationgship of courses)
SC: O(V + E), V for entries, E for total listed elements

Follow-up:
courses schedule 2? return order of courses, so i will print dequeue numbers' order
 */