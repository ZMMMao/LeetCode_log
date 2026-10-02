/**
restate:
    input: int n, k
    output: a list of int combinations of k numbers
    constraint: n in [1, 20], k in [1, n]

clarify:
    k always equal or less than n?
    guaranteed no duplicate numbers
    empty input?
    start at?

approach:
    enumeration: backtracking
    list all the possible combs
    for first elements (1 in this problem), find all possible k elements combs and move to 2., until the last index which can fit k elements (n-k)

    TC: O(C(n,k) * k)
    SC: O(k)

edge case:
    empty input
    n = 1, k = 1 (k = n)
    n = 3, k = 2 (k<n)

dry-run:
    input:[1, 1]
    start/i = 1, path: {1}, -> path size = k, add {1},  return to for loop, 
    i++ -> i = 2 break loop, return to main -> return result

    input [3, 2]
    start/i = 1, path.add(1) -> path: {1}, i++ -> i = 2, traverse inner function 
    i = 2, path.add(2) -> path: {1, 2}, path size = k -> add res: {{1, 2}}, path.removeLast -> path: {1}
    i = 3, path.add(3) -> path: {1, 3}, path size = k -> res: {{1, 2}, {1, 3}}, path.removeLast -> path: {1}
    i = 4, return to i = 1, path remove last -> path: {}, i++ -> i = 2

    i = 2, path.add(2) -> {2}, traverse(2)
    i = 3, path.add(3) -> {2, 3} -> size = k -> add res: {{1,2}, {1,3}, {2,3}}, path remove last -> {2}
    i = 4 return to previous function
    
    i = 3 i > n - k + 1 (2) return;

    return to main function, return res as {{1,2}, {1,3}, {2,3}}

follow-up:
    i did pruning in n - (k -  path.size()) + 1
    
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if(k > n || k == 0) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        traverse(1, k, new ArrayList<>(), res, n);
        return res;
    }

    private void traverse(int start, int k, List<Integer> path, List<List<Integer>> res, int n){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i <= n - (k-path.size()) + 1; i++){
            path.add(i);
            traverse(i+1, k, path, res, n);
            path.remove(path.size() - 1);
        }
    }
}