/**
restate:
    input: int n
    output: all combinations of parentheses
    constraint: n in [1, 8]
clarify:
    valid parentheses (closed)?
    only one kind of parentheses?
approach:
    valid parentheses: must left = right, left must > right before fulfilled
    if right < left, can add ')'
    if left < n, can add '('
    if left == right == n, add res
    TC: O(2^n)
    SC: O(n)
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        if(n == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        dfs(0, 0, new StringBuilder(), res, n);
        return res;
    }

    private void dfs(int left, int right, StringBuilder path, List<String> res, int n){
        if(left == right && left == n){
            res.add(path.toString());
            return;
        }

        if(left < n){
            path.append('(');
            dfs(left+1, right, path, res, n);
            path.deleteCharAt(path.length() - 1);
        }

        if(right < left){
            path.append(')');
            dfs(left, right+1, path, res, n);
            path.deleteCharAt(path.length() - 1);
        }
    }
}