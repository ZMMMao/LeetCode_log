/**
two pointer, i, left, right
skip  duplicates, 
sort first
TC: O(n^2)
SC: O(1)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums); //O(nlogn)

        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1;
            int right = n - 1;
            while(left < right){
                int target = nums[i] + nums[left] + nums[right];
                if(target < 0) left++;
                else if(target > 0) right--;
                else{
                    res.add(List.of(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}