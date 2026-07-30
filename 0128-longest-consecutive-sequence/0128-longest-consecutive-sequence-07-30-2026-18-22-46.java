/**
unsorted array, find the longest consecutive elements
Approach:
1. brute force: sorting - merge/binary -> TC: O(nlogn) SC: O(1)
2. optimal: hashset check num-1 and count. 
TC: O(n)
SC: O(n)
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        Set<Integer> seen = new HashSet<>();
        int count = 0;
        int res = 0;

        for(int n : nums) seen.add(n);

        for(int x : seen){
            if(seen.contains(x - 1)) continue;
            while(seen.contains(x)){
                x++;
                count++;
            }
            res = Math.max(res, count);
            count = 0;
        }

        return res;
    }
}