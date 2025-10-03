class Solution {
    public int integerBreak(int n) {
        int[] memo = new int[n+1];
        memo[1] = 1;

        for(int i = 2; i <= n; i++){
            int best = 0;
            for(int j = 1; j < i; j++){
                best = Math.max(best, Math.max(memo[i - j] * j, (i - j)*j));
            }
            memo[i] = best;
        }
        return memo[n];
    }
}
/**
TC: O(n^2)
SC: O(n)
 */