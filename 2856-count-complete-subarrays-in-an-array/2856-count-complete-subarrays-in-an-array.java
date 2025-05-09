/**
Algo: linear sort
Data Structure: HashMap, two pointer
TC: O(n)
SC: O(n)
 */
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> count = new HashMap<>();
        for(int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int sz = count.size();
        count.clear();
        int left = 0;
        int res = 0;
        for(int i = 0; i < n; i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            while(count.size() == sz){
                count.put(nums[left], count.get(nums[left]) - 1);
                if(count.get(nums[left]) == 0){
                    count.remove(nums[left]);
                }
                left++;
            }
            res += left;
        }
        return res;
    }
}