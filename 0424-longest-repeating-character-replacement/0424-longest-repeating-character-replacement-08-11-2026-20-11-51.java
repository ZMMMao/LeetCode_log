/**
1. restate:
String s, int k
perform a change to 1 uppercase letter up to k times
output: length of longest substring has same letter with k changes
2. clarify:
onle uppercase? yes
string length [0, 10^5]
k length [0, s]
3. approach:
brute force:
    for(i >= k) another pointer j from the begining count if unique letters <= k
    TC: o(n^2)
    SC: O(1)
    issue, repeated from 0 traverse, wasting time
optimization:
    we will count as well as we move the pointer forward
    we need to map the char to count, we need to have a global currMaxChar, r - l - currMaxChar <= k
    sliding window problem
    TC: O(n)
    SC: O(n)
 */
class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0) return 0;

        Map<Character, Integer> count = new HashMap<>();
        int left = 0, right = 0;
        int maxLen = 0;
        char[] sc = s.toCharArray();
        int charCount = 0;

        while(right < sc.length){
            char curr = sc[right];
            count.put(curr, count.getOrDefault(curr, 0) + 1);
            charCount = Math.max(count.get(curr), charCount);
            right++;
            while(right - left - charCount > k){
                char l = sc[left];
                count.put(l, count.get(l) - 1);
                if(count.get(l) == 0) count.remove(l);
                left++;
            }
            maxLen = Math.max(right - left, maxLen);
            
        }
        return maxLen;
    }
}
/**
dryrun "ABCAB", k = 2
left        right           maxLen       map                    charCount
0              1                1         (A, 1)                    1
0              2                2       (A, 1), (B, 1)              1
0              3                3       (A, 1), (B, 1), (C, 1)      1
0              4                4        (A, 2), ..., ...           2
1              5                4        (A,2),(B, 2), (C, 1)      2 

maxLen = 4
 */