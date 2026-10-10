/**
input: numCourses, int[][] prerequisites
output: int[] order of course we should take
constraint: numCourses in [1, 2000], prerequisites.length in [0, 4* 10^6]

clarify:
if courses are no-prerequisites, any order?

approach:
graph, mapping from and to
indegree array, count prerequiesites course
a queue, enqueue when indegree == 0
every poll from queue, add to the result list
return result list if result list size == numCourse or empty array
TC: O(V+E), V = numCourses, E = prerequisites.length;
SC: O(V+E)

dry-run:
input: 2, [[1, 0]]
map: [(0 ,(1))]
indegree: [0, 1]
queue: [0]
res: [0]

queue: [1]
res: [0, 1], size = numsCourses

return [0, 1]
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < numCourses; i++) map.put(i, new ArrayList<>());

        int[] indegree = new int[numCourses];
        List<Integer> res = new ArrayList<>();
        for(int[] edge : prerequisites){
            int from = edge[1];
            int to = edge[0];
            map.get(from).add(to);
            indegree[to]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            int curr = queue.poll();
            res.add(curr);
            for(int next : map.get(curr)){
                if(--indegree[next] == 0) queue.offer(next);
            }
        }

        if(res.size() != numCourses) return new int[0];
        int[] order = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            order[i] = res.get(i);
        }
        return order;
    }
}