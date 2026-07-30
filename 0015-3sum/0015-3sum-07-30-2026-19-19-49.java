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
        Set<List<Integer>> check = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            int target = -nums[i];
            int left = i+1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[left] + nums[right];
                if(sum == target){
                    check.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }else if(sum > target){
                    right--;
                }else if(sum < target){
                    left++;
                }
            }
        }

        for(List<Integer> triplet : check){
            res.add(triplet);
        }

        return res;
    }
}