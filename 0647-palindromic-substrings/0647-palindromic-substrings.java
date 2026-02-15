/**
input:
    type: String
    length: [1, 1000]
    lowercase English letter
output:
    type: int
edge case:
     s == null return 0;
approach:
    brute force: 
        generate every palindromic substring
        2 pointer
        TC: O(n^3)
        SC: O(1)
    optimal:
        center expand
        // center palindrom aba
        // pair palindrom abba
 */
class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        int total = 0;
        for(int i = 0; i < s.length(); i++){
            total += expandAndCount(s, i, i); //aba

            total += expandAndCount(s, i, i+1); //abba
        }

        return total;
    }

    private int expandAndCount(String s, int l, int r){
        int count = 0;

        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
            count++;
        }

        return count;
    }
}