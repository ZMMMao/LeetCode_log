/**
Algo: linear sorting
Data Structure: HashMap - counting for pairs
TC: O(n)
SC: O(n)
 */
class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int n = nums.length;
        int pair = 0;
        int left = 0;
        long res = 0;
        for(int i = 0; i < n; i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            pair += count.get(nums[i]) - 1;
            
            while(pair >= k){
                pair-= count.get(nums[left]) - 1;
                count.put(nums[left], count.get(nums[left]) - 1);
                left++;
            }       
            res += left;
        }
        return res;
    }
}