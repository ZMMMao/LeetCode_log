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
    TC: O(n)
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
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) return;

        int zero = 0;
        int one = 0;
        while(zero < nums.length && one < nums.length){
            if(nums[zero] == 0){
                one = zero;
                while(one < nums.length && nums[one] == 0) one++;
                if(one == nums.length) return;
                nums[zero] = nums[one];
                nums[one] = 0;
                
            }
            zero++;
        }
    }
}