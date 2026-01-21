/**
input:
    type: int
    range: [1, 100]
output:
    int path
edge case:
 0 0 return 0
approach:
    dp + memo
    TC: O(m*n)
    SC: O(m*n)
 */
class Solution {
    public int uniquePaths(int m, int n) {
        if(m <= 0) return n;
        if(n <= 0) return m;

        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;

        for(int i = 0; i < m; i++){
            for(int j = 0; j< n; j++){
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j];
            }
        }

        return dp[m][n];
    }
}