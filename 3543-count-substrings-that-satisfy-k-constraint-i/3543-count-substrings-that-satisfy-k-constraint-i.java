/**
Algo: two pointer, array for counting(map)
Data Structure: array
TC: O(n)
SC: O(1)
 */
class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int[] count = new int[2];
        int n = s.length();
        int res = 0;
        int left = 0;
        char[] arr = s.toCharArray();
        for(int right = 0; right < n; right++){
            char curr = arr[right];
            if(curr == '1') count[1]++;
            else count[0]++;

            while(count[0] > k && count[1] > k){
                char l = arr[left];
                if(l == '1') count[1]--;
                else count[0]--;
                left++;
            } 
            res += right - left + 1;
        }
        return res;
    }
}