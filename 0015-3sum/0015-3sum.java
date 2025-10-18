class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return helper(nums, 0);
    }
    public List<List<Integer>> helper(int[] nums, int target){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            List<List<Integer>> pairs = twoSum(nums, i + 1, target - nums[i]);
            for(List<Integer> pair : pairs){
                res.add(Arrays.asList(nums[i], pair.get(0), pair.get(1)));
            }
            while(i < n - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }
    public List<List<Integer>> twoSum(int[] nums, int left, int target){
        List<List<Integer>> pairs = new ArrayList<>();
        int right = nums.length - 1;
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){;
                pairs.add(Arrays.asList(nums[left], nums[right]));
                int l = nums[left];
                int r = nums[right];
                while(left < right && nums[left] == l) left++;
                while(left < right && nums[right] == r) right--;
            }
            else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return pairs;
    }
}
/**
TC: O(n^2)
SC: O(1)
 */