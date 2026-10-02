/**
restate:
    input: int[] nums
    output: all possible permutations
    constraint: nums.length in [1, 6], nums[i] in [-10, 10]

clarify:
    output order?
    no duplicates?

approach:
    backtracking: each level fills with unused numbers, 
    using a visited array to avoid re-use
    recurse with 0, marked visited and skip if true
    record the path if its length reaches n

    TC: O(n * n!)
    SC: O(n)
 */

/**
test case: [1, 2]
dry run:
dfs([])  - bound: i < 2
    i = 0, visited[0] = true 
    -> dfs([1]):
        i = 0, skip
        i = 1, visited[1] = true -> [1, 2]
    
    i = 1, visited[1] = true
    -> dfs([2]):
        i = 0 -> [2, 1]
        i = 1, skip
res: [[1, 2], [2, 1]]  

follow-up:
    what if duplicates?
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        traverse(nums, visited, new ArrayList<>(), res);
        return res;
    }

    private void traverse(int[] nums, boolean[] visited, List<Integer> path, List<List<Integer>> res){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            path.add(nums[i]);
            visited[i] = true;
            traverse(nums, visited, path, res);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}