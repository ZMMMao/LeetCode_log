/**
hashmap, mapping char to frequency
TC: O(n)
SC: O(n)
 */
class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;

        char[] cs = s.toCharArray();
        Map<Character, Integer> count = new HashMap<>();
        for(int i = 0; i<cs.length; i++){
            count.put(cs[i], count.getOrDefault(cs[i], 0) + 1);
        }

        for(int i = 0; i<cs.length; i++){
            if(count.get(cs[i]) == 1) return i;
        }

        return -1;
    }
}