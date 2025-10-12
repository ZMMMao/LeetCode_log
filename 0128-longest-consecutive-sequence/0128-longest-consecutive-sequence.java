class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int maxLen = 0;

        for(int x : set){
            if(!set.contains(x - 1)){
                int cnt = 1;
                int curr = x;
                while(set.contains(curr + 1)){
                    curr++;
                    cnt++;
                }
                maxLen = Math.max(cnt, maxLen);
            }
        }
        return maxLen;
    }
}
/**
TC: O(n)
SC: O(n)
 */
