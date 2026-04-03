/**
input: 
    type: int[]
    length: [1, 10^4]
    nums[i]: [0, 1000]
output:
    int
edge case:
    nums == null return -1
approach:
    dp + memo
    TC: O(n)
    SC: O(1)
 */
class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int curRight = 0;
        int nextRight = 0;
        int res = 0;

        for(int i = 0; i < nums.length - 1; i++){
            nextRight = Math.max(nextRight, i + nums[i]);
            if(i == curRight){
                curRight = nextRight;
                res++;
            }
        }
        return res;
    }
}