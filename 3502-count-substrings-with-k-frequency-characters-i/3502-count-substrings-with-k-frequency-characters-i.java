/**
Algo: Sliding Window
Data Struc: HashMap for counting appearance
TC: O(n)
SC: O(n)
 */


class Solution {
    public int numberOfSubstrings(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        Map<Character, Integer> count = new HashMap<>();
        int left = 0;
        int res = 0;
        for(int right = 0; right < n; right++){
            char curr = arr[right];
            count.put(curr, count.getOrDefault(curr, 0) + 1);
            while(count.get(curr) >= k){
                char l = arr[left];
                count.put(l, count.get(l) - 1);
                left++;
            }
            res += left;
        }
        return res;
    }
}