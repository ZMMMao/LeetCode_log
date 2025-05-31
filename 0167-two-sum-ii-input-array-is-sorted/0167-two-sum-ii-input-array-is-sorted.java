/**
Algo: two pointer
Data Structure: int array
TC: O(n)
SC: O(1)
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target) break;
            else if(sum > target){
                right--;
            }
            else{left++;}
        }
        return new int[]{left + 1, right + 1};
    }
}