class Solution {
    /**
    DP + HashSet:
        sub-problem: segment, maxLen
        iteration
        memo update
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int maxLen = 0;
        for(String word : wordDict){
            maxLen = Math.max(maxLen, word.length());
        }
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        Set<String> words = new HashSet<>(wordDict);
        return dp(n, s, maxLen, words, memo) == 1;
    }

    private int dp(int i, String s, int maxLen, Set<String> words, int[] memo){
        if(i == 0) return 1;

        if(memo[i] != -1) return memo[i];

        for(int j = i - 1; j >= Math.max(i - maxLen, 0); j--){
            if(words.contains(s.substring(j , i)) && dp(j, s, maxLen, words, memo) == 1){
                return memo[i] = 1;
            }
        }
        return memo[i] = 0;
    }
}
/**
TC: O(nL^2), L = maxLen, O(n·L) candidates × O(L) per candidate (substring copy + first-time hash) → O(n·L²). 
    n cases and for each cost: substing L * Hashset search L
SC: O(n)
 */