/**
1. restate: 
input: binary array nums
output: maxLen - contiguous subarray with equal 1 and 0
2. clarify:
array length: [1, 10^5]
3. approach:
    Brute Force:
    for int i, another index j from [0, i], counting numbers of 1 and 0.
    TC: O(n^2), SC: O(1), problem: repeated traverse from the start, wasteful
    Optimization:
    use a map to save the prefix to index;
    if 1 prefix + 1; if 0, prefix -1;
    map the prefix to the first apperance
    TC: O(n)
    SC: O(n)
 */
class Solution {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> firstIndexByPrefix = new HashMap<>();
        firstIndexByPrefix.put(0, -1);
        int prefix = 0, maxLen = 0;
        
        for(int i = 0; i<nums.length; i++){
            prefix += (nums[i] == 1) ? 1 : -1;
            Integer first = firstIndexByPrefix.get(prefix);
            if(first != null) maxLen = Math.max(maxLen, i - first);
            else firstIndexByPrefix.put(prefix, i);
        }
        return maxLen;
    }
}

/**
Dry run: [0,1,1,0]
i           prefix          map                         maxLen
0            -1              (0,-1)(-1, 0)                   0
1            0               (0,-1)                       2
2            1                (0, -1) (1, 2)              2
3            0                 same above                 4      
return 4
 */