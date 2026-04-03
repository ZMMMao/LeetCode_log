/**
input:
    int n
    [1, 45]
output: 
    int step
edge case:
    n <= 1 return 1
approach:
    dp
    TC: O(n)
    SC: O(1)
 */
class Solution {
    public int climbStairs(int n) {
        if(n <= 1) return 1;
        int f_0 = 0;
        int f_1 = 1;
        for(int i = 1; i <= n; i++){
            int temp = f_1;
            f_1 = f_0 + f_1;
            f_0 = temp;
        }
        return f_1;
    }
}