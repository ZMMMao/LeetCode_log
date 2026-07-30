/**
3 sum, no duplicate triplets
fixed i with j,k as two pointer to search, hashset as result
TC: O(n^2)
SC: O(n)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return new ArrayList<>();

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i<nums.length-2; i++){
            if(nums[i] > 0) break;
            if(i>0 && nums[i] == nums[i-1]) continue;

            int target = -nums[i];
            int left = i+1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[left] + nums[right];
                if(sum == target){
                    res.add(List.of(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1])left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }else if(sum > target){
                    right--;
                }else if(sum < target){
                    left++;
                }
            }
        }
        return res;
    }
}