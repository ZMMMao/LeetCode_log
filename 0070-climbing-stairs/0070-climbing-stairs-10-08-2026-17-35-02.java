/**
input: int n
output: int distinct ways
constarint: n in [1, 45]

clarify:
can only climb 1 or 2 steps?
must reach to last stair or can jump over?

approach:
for dp[i], it's the total ways to climb;
dp[i] = dp[i-1] + dp[i-2];
base case:
dp[0] = 1;
dp[1] = 1;
result: dp[n]

TC: O(n)
SC: O(n)
 */
class Solution {
    public int climbStairs(int n) {
        if(n <= 1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}