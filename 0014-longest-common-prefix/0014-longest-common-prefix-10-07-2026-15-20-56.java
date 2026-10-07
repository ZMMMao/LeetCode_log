/**
approach:
match string by string 
res = first string, and match with next to append a stringBuilder and make the new string,
early pruning, if ""
returun the final res;
TC: O(n*L)
SC: O(L)
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";

        String res = strs[0];
        for(int i = 1; i < strs.length; i++){
            int c = 0;
            while(c < res.length() && c < strs[i].length() && res.charAt(c) == strs[i].charAt(c)){
                c++;
            }
            if(c == 0) return "";
            res = res.substring(0, c);
        }
        return res;
    }
}