/**
restate:
    input: String s
    output: longest palindromic substring
    constraint: s.length(): [1, 1000], s only digits and english letters

clarify:
    string letters are uppercase and lowercase? 
    upper and lower consider as different?

approach:
    center expension
    from the middle point, use two pointer to expand to left and right
    two situations: 
    1. length is odd, expand from center
    2. length is even, expand from center - 1 (l) and center + 1 (r)
    use the expand helper function to create both substring, update the result everytime
    the above solution is a little wasted on space
    curr[0] = right
    curr[1] = leftIdx
    max[0] = right
    max[1] = bestLeft

    improvement: record the rightIdx and startIdx, so that no need create string each time
    helper function return the len of the substring

    TC: O(n^2)
    SC: O(1), excluding output
 */
 /**
dry-run:
    test case: aba
    aba:
    odd case:
    i = 0,  
    char: 'a'
    curr[0] = 1
    curr[1] = 0
    max[0]  = 1
    max[1]  = 0

    i = 1,  
    char: 'a' 'b'
    curr[0] = 2
    curr[1] = 0
    max[0]  = 2
    max[1]  = 0

    i = 2,  
    char: 'a' 'b' 'a'
    curr[0] = 2
    curr[1] = 2
    max[0]  = 2
    max[1]  = 0



follow-up: 
optimization based on current solution:
 1. clarity
 2. time: 
    manchaster method:
     insert symbol between, mirroring, only right index move forward
  */
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        int[] max = new int[2];
        int[] curr = new int[2];
        for(int i = 0; i < s.length(); i++){
            expand(i, i, curr, s);
            if(curr[0] > max[0]){
                max[0] = curr[0];
                max[1] = curr[1];
            }
            expand(i, i+1, curr, s);
            if(curr[0] > max[0]){
                max[0] = curr[0];
                max[1] = curr[1];
            }
        }
        return s.substring(max[1], max[1] + max[0]);
    }

    private void expand(int l, int r, int[] curr, String s){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        curr[0] = r - l - 1;
        curr[1] = l+1;
    }
}