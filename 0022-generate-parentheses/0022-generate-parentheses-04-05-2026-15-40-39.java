/**
input:
    - type: int
    - range: [1, 8]
output: 
    List<String>
edge case:
    n = 0 return empty list
approach:
    backtracking
    TC: O(C(2n,n))
    SC: O(n)
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0) return res;
        backtracking(n, n, new StringBuilder(), res);
        return res;
    }

    public void backtracking(int l, int r, StringBuilder sb, List<String> res){
        if(r < l) return;

        if(l < 0 || r < 0) return;

        if(l == 0 && r == 0){
            res.add(sb.toString());
            return;
        }

        sb.append('(');
        backtracking(l-1, r, sb, res);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        backtracking(l, r-1, sb, res);
        sb.deleteCharAt(sb.length() - 1);

    }
}