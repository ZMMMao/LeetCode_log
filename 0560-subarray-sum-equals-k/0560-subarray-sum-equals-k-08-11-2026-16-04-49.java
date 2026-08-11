/**
1. restate
input: int[], int k
output: numbers, subarrays -> sum to k
2. clarify: 
subarray: contiguous, non-empty, unsorted
constraints range: 
    k: [-10^7, 10^7]
    array numbers: [-1000, 1000]
    array length: [1, 2* 10^4]
edge case:
    empty input return 0
3. Approach:
    brute force:
        a for loop, for nums[i], find a contiguous sequence by sum-all, if found, count++;
        TC: O(n^2), SC: O(1)
    optimization:
        prefix sum array to store the previous sum
        for num[i]: map.get(prefix[i] - k), found a previous prefix[j] = p[i] - k --- use a map of value - count of matched prefix sum;
                    
        TC: O(n)
        SC: O(n)
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int prefix = 0, count = 0;
        Map<Integer, Integer> preCount = new HashMap<>();
        preCount.put(0, 1);
        
        for(int i = 0; i < n; i++){
            prefix += nums[i];
            count += preCount.getOrDefault(prefix - k, 0);
            preCount.merge(prefix, 1, Integer::sum);
        }
        return count;
    }
}