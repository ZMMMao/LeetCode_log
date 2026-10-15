/**
input: int[] nums, int k
output: int. count of subarrays
constraint nums, k in integer range

clarify:
subarray: any index start?
the sum is still integer value?

approach:
nested loop, for each i, find a j >=i and sum between i,j is k
TC: O(n^2)
SC: O(1)

better:
sum + hashmap sum -> freq, one pass
TC: O(n)
SC: O(n)

dry-run: k = 2^31
[1, 0, max, max]
i = 1, pre = [0], remain = max
i = 2, pre = [0, 1], remain = k
i = 3, pre = [0, 1, 1+max], remain = 0, count++;
i = 4, pre = [0, 1, 1+max, 1+2max], remain = max;
count = 1;
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        Map<Long, Integer> freq = new HashMap<>();
        freq.put(0L, 1);
        long sum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            count += freq.getOrDefault(sum - k, 0);
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
/**
dry run: [1, -1, 2], k = 2
num                  1      -1          2
prefix       0       1       0          2
preCount   (0, 1)  (1, 1)   (0, 2)      (2, 1)
count        0       0       0          2
 */