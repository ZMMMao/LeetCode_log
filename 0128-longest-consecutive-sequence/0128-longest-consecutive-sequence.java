/**
input:
    type: int[]
    length: [0, 10^5]
    nums[i]: [-10^9, 10^9]
output:
    int maxLen
edge case:
    nums == null return 0;
approach:
    brute force: sorting, TC: O(nlogn)
    optimal: hashSet + find n+1 by iterating set
    TC: O(n)
    SC: O(n)
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        Set<Integer> count = new HashSet<>();
        for(int num : nums){
            count.add(num);
        }
        int maxLen = 0;
        int n = nums.length; 

        for(int cur : count){
            if(count.contains(cur - 1)) continue; 
            
            int curLen = 1;

            while(count.contains(cur + 1)){
                cur++;
                curLen++;
            }
            maxLen = Math.max(curLen, maxLen);
        }

        return maxLen;
    }
}