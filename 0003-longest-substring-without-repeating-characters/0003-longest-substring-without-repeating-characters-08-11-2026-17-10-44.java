/**
1.reinstate:
    input: String s
    output: length of longest substring w/o dups
2. clarify:
    substring: contigous, non-empty
    no duplicates
    string char type: letters, digits, symbols, spaces
    s.length range: [0, 10^5]
3. Approach:
    brute force: for a char at i, traverse (0, i) for all the substring, find longest non-duplicate
        TC: O(n^2), SC: O(n) - hashset
    optimization:
        sliding window, use i and j to find a range from [i, j], if duplicates i++ OR if valid j++
        using hashmap to count (charAt(i), freqency)
        TC: O(n)
        SC: O(n)
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;

        char[] sc = s.toCharArray();
        int i = 0, j = 0;
        Map<Character, Integer> freq = new HashMap<>();
        int maxLen = 0;

        while(j < sc.length){
            char curr = sc[j];
            freq.put(curr, freq.getOrDefault(curr, 0) + 1);
            while(i < j && freq.get(sc[j]) > 1){
                freq.put(sc[i], freq.get(sc[i]) - 1);
                i++;
            }
            int currLen = j - i + 1;
            maxLen = Math.max(currLen, maxLen);
            j++;
        }
        return maxLen;
    }
}