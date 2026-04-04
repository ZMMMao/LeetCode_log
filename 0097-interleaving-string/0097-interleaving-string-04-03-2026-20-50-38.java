/**
input:
    type: string
    length: [0, 200]
output:
    boolean
edge case:
    if all empty string return true
approach:
    two pointer
    TC: O(mn)
    SC: O(mn)
 */
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null && s2 == null && s3 == null) return true;

        int m = s1.length();
        int n = s2.length();

        if(s3.length() != m+n) return false;

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for(int i = 1; i <= m; i++){
            dp[i][0] = dp[i-1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }

        for(int j = 1; j <= n; j++){
            dp[0][j] = dp[0][j-1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j<=n; j++){
                char currentS = s3.charAt(i + j - 1);

                if(currentS == s1.charAt(i - 1)){
                    dp[i][j] = dp[i][j] || dp[i-1][j];
                }

                if(currentS == s2.charAt(j - 1)){
                    dp[i][j] = dp[i][j] || dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}