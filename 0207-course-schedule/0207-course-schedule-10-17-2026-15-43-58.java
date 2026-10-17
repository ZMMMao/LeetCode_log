/**
input: int numCourses, int[][] prerequisites
output: boolean true if can finish all
constraint: numCourses in [1, 2000], prerequisites in [0, 5000]

clarify: 
1. pre[i] is a pair?
2. for the pre[i] pair = [a, b], must finish b before a?
3. CourseId is integer?

approach:
1. build a graph: hashmap -> courseID to a list of nextCourse
2. indegree array: check how many prerequisites does a single course need?
3. queue: add all courses i with indegree[i] == 0, and BFS for next

TC: O(V + E), V for vertexs/nodes is numCourses, E for edge is the prerequisites.length
SC: O(V*E) because the map entry: V -> E


edge case: 
[0, 1], [1, 0]

map: [0:1, 1:0]
indegree: [1, 1]
queue is empty -> indegree[i] != 1 return false;

test case: [1, 0], [2, 1],
map: [0:1, 1:2]
indegree: [0, 1, 1]
queue: [0] -> next: [1] -> indegree-- -> enqueue(1)
queue: [1] -> next: [2] -> indegree-- -> enqueue(2)
queue: [2] -> no next -> queue is empty -> break
indegree: [0, 0, 0]
return true;

followo-up: return index list as an order to study?
use a result list and during the enqueue, we add course to it
if result size == numCourses, return it or -1
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        if(pre == null || pre.length == 0 || pre[0].length == 0) return true;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < numCourses; i++) map.put(i, new ArrayList<>());
        int[] indegree = new int[numCourses];
        for(int[] p : pre){
            int from = p[1];
            int to = p[0];
            indegree[to]++;
            map.get(from).add(to);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0)queue.offer(i);
        }    

        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int next : map.get(curr)){
                indegree[next]--;
                if(indegree[next] == 0) queue.offer(next);
            }
        }

        for(int i : indegree){
            if(i != 0) return false;
        }
        return true;
    }
}