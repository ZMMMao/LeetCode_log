/**
Algo: counting even number index
Data Structure: pointer
TC: O(n)
SC: O(1)
 */

class Solution {
    public long evenProduct(int[] nums) {
        long res = 0;
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] % 2 == 0){
                count = i + 1;
            }
            res += count;
        }
        return res;
    }
}