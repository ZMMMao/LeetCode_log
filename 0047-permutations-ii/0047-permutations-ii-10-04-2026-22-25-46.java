/**
restate:
    input: int[] array
    output: all unique permutations 
    constraint: nums.len in [1, 8], nums[i] in [-10, 10]

clarify:
    contains duplicates?
    sorted or not?
    empty input

approach:
    sort the array
    backtracking: each level fill the next position with any unused number
    dedup: skip nums[i] if nums[i] == nums[i-1] and visited[i-1] is false.
    This forces identical values to be used left to right, so each distinct permutation is generated once.
    for each level, pick from 0-index for next elements
    record if path.len = nums.len

    TC: O(n!), P(n, n), nlogn of sorting cost can be ignored in this case
    SC: O(n)

edge cases:
    duplicates numbers: [1, 1, 2]

dry-run:
int[] : [1, 1, 2]
    dfs(path: [])
    i = 0, add nums[0] = 1 -> visited: [1]; path: [1];
        -> dfs([1]):
            i = 1, add 1 -> [1, 1]
            -> dfs([1, 1])
                i = 2, add 2 -> [1, 1, 2]
                path.len = n -> add res [1,1,2]

            i = 2, add 2 -> [1, 2]
            -> dfs()
                i = 1, add 1 -> [1, 2, 1]
                res.add -> [1, 2, 1]

    i = 1 dfs([])
    skip duplicates

    i = 2, dfs([]):
        add 2 -> [2]
        dfs([2]):
            i = 0, add 1 -> [2, 1]
            i = 1, add 1 -> [2, 1, 1]
            res.add -> [2, 1, 1]
    return res: {[1, 1, 2][1, 2, 1][2, 1, 1]}

follow-up:

 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        traverse(nums, new ArrayList<>(), visited, res);
        return res;
    }

    private void traverse(int[] nums, List<Integer> path, boolean[] visited, List<List<Integer>> res){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            if(i > 0 &&  !visited[i - 1] && nums[i] == nums[i - 1]) continue;
            
            path.add(nums[i]);
            visited[i] = true;
            traverse(nums, path, visited, res);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}