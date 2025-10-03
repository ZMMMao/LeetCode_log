class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int f0 = 0;
        int f1 = 0;
        for(int i = 1; i < cost.length; i++){
            int newF = Math.min(f1 + cost[i], f0 + cost[i-1]);
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }
}

/**
        int n = cost.length;
        int[] min = new int[n + 1];
        for(int i = 2; i <= n; i++){
            min[i] = Math.min(min[i - 1] + cost[i-1], min[i-2] + cost[i-2]);
        }
        return min[n];
    }
  
TC: O(n)
SC: O(1)
 */