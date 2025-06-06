/**
Algo: linear sort, two pointer
Data Structrue: array, two pointer

Time: 14m15s; 
Takeaway: sort arr first + exclude 0

TC: O(n^2)
SC: O(1) in-place

TestCase:
All 0
same number
large number
reverse sorted number
all odd
all even
empty

 */
class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        Arrays.sort(nums);
        if(n == 0) return res;

        for(int i = n - 1; i > 1; i--){
            if(nums[i] == 0) return res;
            int left = 0;
            int right = i - 1;
            while(left < right){
                while(nums[left] == 0) left++;
                if(nums[right] == 0) return res;
                int edge_sum = nums[left] + nums[right];
                if(edge_sum > nums[i]){
                    res += right - left;
                    right--;
                } else{
                    left++;
                }
            }
        }
        return res;
    }
}