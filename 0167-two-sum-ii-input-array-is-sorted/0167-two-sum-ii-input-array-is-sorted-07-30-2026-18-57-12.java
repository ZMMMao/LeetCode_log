/**
sorted array; index+1 as res array
1. origin: hsahmap + count remaining num - O(n) space
2. two pointer from head and tail, narrowing ranges
TC: O(n)
SC: O(1)
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0) return new int[0];

        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            if(numbers[left] + numbers[right] == target) return new int[]{left+1, right+1};
            if(numbers[left] + numbers[right] > target) right--;
            if(numbers[left] + numbers[right] < target) left++;
        }

        return new int[0];
    }
}