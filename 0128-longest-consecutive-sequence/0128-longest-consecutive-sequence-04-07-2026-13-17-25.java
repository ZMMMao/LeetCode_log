/**
brute force: sorting nlogn
optimal: 
hashSet
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int maxLen = 0;
        Set<Integer> set = new HashSet<>();

        for(int num : nums) set.add(num);

        for(int num : set){
            if(set.contains(num - 1)) continue;
            int curr = num;
            int count = 0;
            while(set.contains(curr)){
                count++;
                curr++;
            }
            maxLen = Math.max(count, maxLen);
        }
        return maxLen;
    }
}

