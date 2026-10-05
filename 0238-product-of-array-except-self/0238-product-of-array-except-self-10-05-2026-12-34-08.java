/**
restate:
    input: int[]
    output: int[]
    constraint: array length in [2, 10^5], nums[i] in [-30, 30]

clarify:
    answers[i] is in integer range?

approach:
    maintain a prefix and a suffix array.
    prefix[0] = 1, suffix[n-1] = 1, safe-guard
    answer[i] = prefix[i] * suffix[i];
    prefix[i] = prefix[i - 1] * nums[i-1];
    suffix[i] = suffix[i + 1] * nums[i+1];

    TC: O(n)
    SC: O(n)
    three passes

edge case:
    array includes 0
    array with negative

dry-run:
test case: [-1, 0, 1]

suffix: [0, 1, 1];
prefix: [1, -1, 0];
answer: [0, -1, 0];

follow-up:
    O(1) space complexity?
        result array as prefix
        use result array multiply the suffix （suffix as an int）
        also prefix as output result
    if can use division?
     need to consider 0
     no 0 just divide by nums[i]
     1 of 0, the positon of 0 is the product of all others, the rest positions are 0
     2+ of 0, all position is 0
     
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] answer = new int[n];
        prefix[0] = 1;
        suffix[n-1] = 1;

        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }        
        for(int j = n - 2; j >= 0; j--){
            suffix[j] = suffix[j+1] * nums[j+1];
        }

        for(int k = 0; k < n; k++){
            answer[k] = prefix[k] * suffix[k];
        }

        return answer;
    }
}