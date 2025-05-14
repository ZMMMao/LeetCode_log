/**
Algo: Sliding window, two pointer, two window trick for exactly K elements--
Data Structure: array, two pointer
TC: O(n)
SC: O(1)
 */

class Solution {
    public long countOfSubstrings(String word, int k) {
        return helper(word, k) - helper(word, k + 1);
    }

    public long helper(String word, int k){
        long res = 0;
        int v = 0;
        int con = 0;
        int left = 0;
        Map<Character, Integer> count = new HashMap<>();

        count.put('a', 0);
        count.put('e', 0);
        count.put('i', 0);
        count.put('o', 0);
        count.put('u', 0);

        char[] w = word.toCharArray();
        for(int right = 0; right < word.length(); right++){
            char c = w[right];
            if(count.containsKey(c)){
                if(count.get(c) == 0){
                    v++;
                }
                count.put(c, count.get(c) + 1);
            } else{
                con++;
            }


            while(v == 5 && con >= k){
                char l = w[left];
                if(count.containsKey(l)){
                    count.put(l, count.get(l) - 1);
                    if(count.get(l) == 0) v--;
                } else{
                    con--;
                }
                left++;
            }

            res += left;
        }
        return res;
    }
}