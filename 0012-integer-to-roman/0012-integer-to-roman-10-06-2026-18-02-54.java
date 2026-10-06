/**
restate:
    input: int num
    output: String that represent the Roman numerals
    constraint: 4/9 rule of subtractive, num in [1, 3999]

clarify:
    subtractive form only happens on 4 or 9 and use the symbol less but closest to the value?

approach:
    special case 4 and 9
    1. / 1000 if > 0 append M
    2. / 500: generally append D
        if > 0 and % 500 = 400 -> case900: add CM
        if = 0 and % = 400 -> case400: append CD
    3. / 100, append C
        if = 0 and % = 90 -> XC
    4. / 50, append L
        if = 0 and % = 40 -> XL
    5. / 10 , append X
        if = 0 and % = 9 -> append IX
    6. / 5 append V
        if = 0 and % = 4 -> append IV
    7. / 1 append I

    a greedy table to map and subtract
    TC: O(n)
    SC: O(1)
 */
class Solution {
    public String intToRoman(int num) {
        if(num < 1 || num > 3999) return new String("");

        StringBuilder res = new StringBuilder();

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for(int i = 0; i < values.length && num > 0; i++){
            while(num >= values[i]){
                res.append(symbols[i]);
                num -= values[i];
            }
        }
        return res.toString();
    }
}