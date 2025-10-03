class Solution {
    public int lengthOfLIS(int[] nums) {
        /** 
        greedy + binarySearch
        TC: O(nlogn)
        SC: O(1)
         */

        int ng = 0;
        for(int num : nums){
            int j = lowerBound(nums, ng, num);
            nums[j] = num;
            if(j == ng) ng++;
        }
        return ng;
    }

    public int lowerBound(int[] nums, int right, int target){
        int left = -1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                right = mid;
            }else{ left = mid;}
        }
        return right;
    }
}
/**
TC: O(n^2)
SC: O(n)
int n = nums.length;
        int[] memo = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    memo[i] = Math.max(memo[i], memo[j]);
                }
            }
            memo[i]++;
            max = Math.max(max, memo[i]);
        }
        return max;
 */