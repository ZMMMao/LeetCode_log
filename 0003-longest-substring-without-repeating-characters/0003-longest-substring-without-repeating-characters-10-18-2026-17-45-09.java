/**
input: String s
output: int length
constraint: s.length in [0, 10^5] and s consists of letters, digits, symbols, spaces

clarify:
all digits, letters and symbols consider as a character?
empty input?

approach:
map to store: char - freq pairs
sliding window to count the substring length
TC: O(n)
SC: O(n)

test case: "abbc"
l = 0, r = 0, charAt(0) = a, freq: {a:1}, max = 1
l = 0, r = 1, charAt(1) = b, freq: {a:1}, {b:1}, max = 2
l = 0, r = 2, charAt(2) = b, freq: {a:1}, {b:2} 
                                -> get(b) > 2, left++, l = 1, freq: {b:2}
                                -> left++, l = 2  freq: {b:1} -> "b" -> max still 2
l = 2, r = 3, charAt(3) = c, freq: {b:1}, {c:1}, max = 2
return 2;
TC: O(n)
SC: O(n)
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;

        int left = 0;
        Map<Character, Integer> freq = new HashMap<>();
        int max = 0;
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            while(freq.get(c) > 1){
                char l = s.charAt(left);
                freq.put(l, freq.get(l) - 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}