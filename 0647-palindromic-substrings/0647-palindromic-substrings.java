class Solution {
    public int countSubstrings(String s) {
        int res = 0;

        for(int i = 0; i < s.length(); i++){
            res += palindromic(s, i, i);
            res += palindromic(s, i, i+1);
        }
        return res;
    }
    
    private int palindromic(String s, int left, int right){
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }
}
/**
TC: O(n^2)
SC: O(n)
 */