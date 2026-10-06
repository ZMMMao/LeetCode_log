/**
restate:
    input: integer x
    output: integer (reversed)
    constraint: x in integer range

clarify:
    can not use long to store mid-calculation?
    overflow return 0

approach:
    use % 10 to get last single digits and digit*10, then /10 to remove the last digit
    max_integer / 10, if before last digits, it's bigger than this, return 0;
    if it's < max_integer but the last digit > 7 return 0;
    TC: O(n), n is the length of digits
    SC: O(1)

test case: 123

 */
class Solution {
    public int reverse(int x) {
        int res = 0;
        while(x != 0){
            int digit = x % 10;
            x /= 10;
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && digit < -8)) return 0;
            res = 10*res + digit;
        }
        return res;
    }
}