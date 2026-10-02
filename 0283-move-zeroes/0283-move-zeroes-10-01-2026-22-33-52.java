/**
restate:
    input: int[]
    output: void, modify the input array so that all 0's are in the end
    constraint: nums.length in [1, 10^4], nums[i] in integer range
    requirement: in-place modification

clarify:

approach:
    two pointer, zero and one
    zero records the 0's position
    one records the first non-0 after zero's index and swap
    TC: O(n^2)
    SC: O(1)
 */
 /**
 dry-run:
    test case: [0, 0, 1, 0, 2]
    zero = 0: 
        nums[zero] = 0, one = 0, one++ -> one = 2
        nums[zero] = nums[one] = 1, zero++ -> zero = 1, nums = [1, 0, 0, 0, 2]
    zero = 1:
        nums[zero] = 0, one = 2 -> one++ -> nums[one] = 2, one = 4
        nums[zero] = nums[one] = 2, nums[one] = 0, nums = [1, 2, 0, 0, 0]
  */
  /**
  follow-up: minimize total number of operation?
   */
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) return;
        
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++){
            if(nums[fast] != 0){
                if(fast != slow){
                    int tmp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = tmp;
                }
                slow++;
            }
        }
    }
}