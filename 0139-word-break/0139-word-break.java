/**
input:
    String, List<String>
output:
    boolean
edge case:
    s == null return false
approach:
    brute force:
    find substring from wordDict every time
    TC: O(2^n)
    SC: O(n)
    optimal:
        memorize + dp
    TC: O(n^2)
    SC: O(n)
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null) return true;

        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();

        boolean[] dp = new boolean[n+1];

        dp[0] = true;

        for(int i = 1; i<=n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}