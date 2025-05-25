/**
Algo: Binary Search + prefixSum
Data Structure: array
TC: O(nlogn + logm)
SC: O(n + m)
*/

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = queries.length;
        
        if(n == 0 || m == 0) return new int[m];
        int[] ans = new int[m];
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for(int i = 1; i < n; i++){
            preSum[i] = preSum[i - 1] + nums[i];
        }

        for(int i = 0; i < m; i++){
            if(preSum[0] > queries[i]) ans[i] = 0; 
            else{ans[i] = binarySearch(preSum, queries[i]);}
        }
        return ans;
    }

    public int binarySearch(int[] preSum, int target){
        int left = 0;
        int right = preSum.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(preSum[mid] > target){
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        return left;
    }
}