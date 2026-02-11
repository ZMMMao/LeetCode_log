/**
input:
    type: String
    length: [1, 16]
    lowercase English letter
output: 
    List<List<String>>
edge case:
    s==null return empty list
approach:
    brute force: try every comb, backtracking
    optimal: dp

 */
class Solution {
    List<List<String>> res = new LinkedList<>();
    List<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return new LinkedList<>();

        backtrack(s, 0);
        return res;
    }

    private void backtrack(String s, int start){
        if(start == s.length()){
            res.add(new LinkedList<>(path));
            return;
        }

        for(int i = start; i < s.length(); i++){
            if(!isPalindrome(s, start, i)) continue;
            
            path.add(s.substring(start, i+1));

            backtrack(s, i+1);

            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int l, int r){

        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}