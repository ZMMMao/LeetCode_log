/**
restate:
    input: int n
    output: List of strings
    constraint: n in [1, 9]

clarify:
    Q for queen and . for empty
    order matters?
    square grid only?
    queen rule? no vertical and horizontal and diagonal connection?

approach:
    dfs, for loop add a first-Q position (i, j) first, 
    in dfs, add a set of column, row and diagonal slope
    check if no conflict, set another Q on the next position.
    if n = 0, add path to res
    TC: O(n!)
    SC: O(n)

 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        for(int i = 0; i < n; i++){
            path.add(".".repeat(n));
        }

        Set<Integer> col = new HashSet<>();
        Set<Integer> dia1 = new HashSet<>();
        Set<Integer> dia2 = new HashSet<>();
        dfs(0, path, res, col, dia1, dia2);
        return res;
    }

    private void dfs(int row, List<String> path, List<List<String>> res, Set<Integer> col, Set<Integer> dia1, Set<Integer> dia2){
        if(row == path.size()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int c = 0; c < path.size(); c++){
            if(!col.contains(c) && !dia1.contains(row - c) && !dia2.contains(row + c)){
                char[] curr = path.get(row).toCharArray();
                curr[c] = 'Q';
                col.add(c);
                dia1.add(row-c);
                dia2.add(row + c);
                path.set(row, new String(curr));
                dfs(row + 1, path, res, col, dia1, dia2);
                dia1.remove(row-c);
                dia2.remove(row+c);
                col.remove(c);
                curr[c] = '.';
                path.set(row, new String(curr));

            }
        }
    }
}