/**
sliding window
most count in window
slide window if window size - mostCount <= k
input: string s and integer k for swap
input size 1 - 10^5
output: int maxLen
TC: O(n)
SC: O(1)
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int maxLen = 0;
        int[] count = new int[26];
        int mostCount = 0;
        char[] ch = s.toCharArray();
        while(right < ch.length){
            int c = ch[right] - 'A';
            count[c]++;
            mostCount = Math.max(mostCount, count[c]);

            while(right - left + 1 - mostCount > k){
                int l = ch[left] - 'A';
                count[l]--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}