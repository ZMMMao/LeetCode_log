/**
restate:
    input: a string of digits
    output: all letters combination of the digits
    constraint: digits in [2, 9], digits.len in [1, 4]
clarify:
    letter 1 and 0 not used
    duplicates?
    lowercase english letter?

approach:
    build a map that mappping digit to letters
    for a dfs solution, each level, fill the next letter/digits onward

    TC: O(n * 4^n), a digit contains max of 4 letters
    SC: O(n)

edge case:
dups: "22"

dry-run:
 digits = "22"
 start = 0, dfs(0):
    path: ['a']
    dfs(1):
        path = ['a', 'a'] -> res.add -> return
        path = [a, b] -> res.add -> return
        path = [a, c] -> res.add -> return
    
    path: [b]
    dfs(1) 
        same loop as char at 'a'
    
    path: [c]
    same loop as previous

follow-up:
    if not only 2-9? Use hashmap to mapping first, key as digit and value as letters
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return new ArrayList<>();

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        dfs(0, digits, new StringBuilder(), res, map);
        return res;
    }

    private void dfs(int start, String digits, StringBuilder path, List<String> res, String[] map){
        if(path.length() == digits.length()){
            res.add(new String(path));
            return;
        }

        int i = digits.charAt(start) - '0';
        for(char c : map[i].toCharArray()){
            path.append(c);
            dfs(start + 1, digits, path, res, map);
            path.deleteCharAt(path.length() - 1);
        }
    }
}