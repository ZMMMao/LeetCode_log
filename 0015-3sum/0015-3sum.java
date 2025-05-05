/**
Algo: linear sort
Data Structure: List, two(3) pointer

 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        if(n == 0 || nums[0] > 0) return res;
        for(int i = 0; i < n - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = n - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if(sum > 0){right--;}
                else{ left++;}
                

            }
        }
        return res;
    }
        
    
}