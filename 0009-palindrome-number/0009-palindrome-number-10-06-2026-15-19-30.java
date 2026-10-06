/**
input: int x
output: boolean true if palindrome
constraint: integer range

clarify:
odd length still matches the pattern
negative always false?
0 as true?

approach:
    revert the integer but can stop in the half as while x > revert
    return x == revert || x = revert / 10

 */
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        int rev = 0;
        while(x > rev){
            rev = rev*10 + x % 10;
            x /= 10;
        }
        return x == rev || x == rev/10;
    }
}