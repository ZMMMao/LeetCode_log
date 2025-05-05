/**
Algo: two pointer, linear sort
Data Structure: array

Time:

TC:
SC:
TestCase:

 */
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        if(n == 0) return;
        int zero = 0;
        int two = n - 1;
        int i = 0;
        while(i <= two){
            if(nums[i] == 0){
                swap(nums, zero, i);
                zero++;
                i++;
            } else if(nums[i] == 2){
                swap(nums, two, i);
                two--;
            } else i++;
        }        
    }
    
    public void swap(int[]nums, int zero, int i){
        int temp = nums[zero];
        nums[zero] = nums[i];
        nums[i] = temp;
    }
}