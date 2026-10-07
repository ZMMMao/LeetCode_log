/**
if needle is length larger, return -1
for char in string if match, use j to match the whole needle
if reach the length, return the char start index
return -1 if not found
TC: O(n * L)
SC: O(1)
*/

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;

        for(int i = 0; i < haystack.length() - needle.length() + 1; i++){
            int c = 0;
            while(haystack.charAt(i + c) == needle.charAt(c)){
                c++;
                if(c == needle.length()) return i;
            }
        }
        return -1;
    }
}