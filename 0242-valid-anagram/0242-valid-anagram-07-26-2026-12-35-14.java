/**
check anagram
all lowercase letters: int[26] for mapping
TC: O(n)
SC: O(1), a array of 26 spaces/letters
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;

        int[] count = new int[26];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for(char cs : sc){
            count[cs - 'a']++;
        }

        for(char ct : tc){
            count[ct - 'a']--;
        }

        for(int i : count){
            if(i != 0) return false;
        }

        return true;
    }
}