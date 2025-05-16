/**
Algo: Sliding window
Data Structure:
TC: O(n)
SC: O(n)
 */
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k + 1);
    }

    public int helper(int[] nums, int k){
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            int curr = nums[right];
            count.put(curr, count.getOrDefault(curr, 0) + 1);
            while(count.size() >= k){
                int l = nums[left];
                count.put(l, count.get(l) - 1);
                if(count.get(l) == 0) count.remove(l);
                left++;
            }
            res += left;
        }
        return res;
    }
}