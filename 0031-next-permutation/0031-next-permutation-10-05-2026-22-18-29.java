/**
restate:
input: int[]
output: void, in-place change
constraint: nums.len in [1, 100], nums[i] in [0, 100]
requirement: SC is O(1), in-place change

clarify:
duplicates?
continuous?

approach:
    scan from tail, if(nums[i] < nums[i-1]) i--;
    if (nums[i-1] > nums[j = n-1]; j--
    swap nums[i-1] & nums[j], reverse nums[i , n-1]

    TC: O(n)
    SC: O(1)

test case:
[1, 1, 4, 3]
[1, 4, 3, 1]
 */
/**
[1, 1, 4, 3]
start: 
i = 3:
    i-- -> i = 2;
    i-- -> i = 1 -> break;
i = 1, j = 3:
    nums[1] < nums[3] -> swap -> tmp = 1, nums[1] = 3, i++ -> i=2, nums[3] = 1; 
    nums = [1, 3, 4, 1]
i = 2, j = 3;
    i<j, tmp = 4, nums[2] = 1, nums[3] = 4 -> nums = [1, 3, 1, 4]

    res = [1, 3, 1, 4]
*/
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int n = nums.length;
        int i = n-2;
        while(i >= 0 && nums[i] >= nums[i+1]) i--;
        
        if(i >= 0){
            int j = n-1;
            while(nums[i] >= nums[j]){
                j--;
            }
            swap(i, j, nums);
        }
        reverse(i+1, n-1, nums);
    }

    private void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int l, int r, int[] nums){
        while(l < r){
            swap(l, r, nums);
            l++;
            r--;
        }
    }
}