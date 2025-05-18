/**
Algo: binary Search
Data Structure: array
TC: O(logn)
SC: O(1)
 */
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = -1;
        if(letters[letters.length - 1] <= target) return letters[0];
        int right = letters.length;

        while(left + 1 < right){
            int mid = left + (right - left)/2 ;
            if(letters[mid] >= (char)(target + 1)){
                right = mid;
            } else{
                left = mid;
            }
        }
        return letters[right];
    }
}