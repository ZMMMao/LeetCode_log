class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] min = new int[n + 1];
        for(int i = 2; i <= n; i++){
            min[i] = Math.min(min[i - 1] + cost[i-1], min[i-2] + cost[i-2]);
        }
        return min[n];
    }
}

/**
TC: O(n)
SC: O(n)
 */