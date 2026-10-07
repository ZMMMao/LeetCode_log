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
        if(strs == null || strs.length == 0) return new String("");

        String res = strs[0];
        for(int i = 1; i < strs.length; i++){
            StringBuilder sb = new StringBuilder();
            int c = 0;
            while(c < res.length() && c < strs[i].length() && res.charAt(c) == strs[i].charAt(c)){
                sb.append(res.charAt(c));
                c++;
            }
            if(sb.length() == 0) return "";
            res = sb.toString();
        }
        return res;
    }
}