/**
input:
    int[]
    length: [1, 10^5]
    gas[i], cost[i] : [0, 10^4]
output:
    int index
edge case: 
    null return -1
approach:
    brute force: dfs traverse and count
    optimal: greedy
        maintain a currentTank for checking the remaining gas / cost ongoing
        TC: O(n)
        SC: O(1)

 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length == 0) return -1;

        int n = gas.length;
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += gas[i] - cost[i];
        }

        if(sum < 0) return -1;

        int currTank = 0;
        int start = 0;
        for(int j = 0; j < n; j++){
            currTank += gas[j] - cost[j];

            if(currTank < 0){
                start = j + 1;
                currTank = 0;
            }
        }
        return start;
    }   
}