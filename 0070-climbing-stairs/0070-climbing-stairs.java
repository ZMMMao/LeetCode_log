class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 0;
        int[] memo = new int[n+1];
        return dfs(n, memo);
    }

    public int dfs(int n, int[] memo){
        if(n <= 1) return 1;
        if(memo[n] != 0) return memo[n];
        return memo[n] = dfs(n - 1, memo) + dfs(n - 2, memo);
    }
}

/**
TC: n
SC: n
 */