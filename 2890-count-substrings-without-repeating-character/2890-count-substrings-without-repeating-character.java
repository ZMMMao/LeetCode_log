/**
Algo: linear sort, sliding window
Data Structure: array as map
TC: O(n)
SC: O(1) (26 letters)
 */

class Solution {
    public int numberOfSpecialSubstrings(String s) {
        int[] count = new int[26];
        char[] arr = s.toCharArray();
        int left = 0;
        int res = 0;
        for(int right = 0; right < arr.length; right++){
            char c = arr[right];
            count[c - 'a']++;
            while(count[c - 'a'] > 1){
                char l = arr[left];
                count[l - 'a']--;
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}