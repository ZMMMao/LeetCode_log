/**
HashMap count + sliding window
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> count = new HashMap<>();
        char[] ch = s.toCharArray();
        int left = 0;
        int len = 0;
        for(int right = 0; right < ch.length; right++){
            char curr = ch[right];
            count.put(curr, count.getOrDefault(curr, 0) + 1);
            while(count.get(curr) > 1){
                char l = ch[left];
                count.put(l, count.get(l) - 1);
                if(count.get(l) == 0) count.remove(l);
                left++;
            }
            len = Math.max(len, right - left + 1);
        }
        return len;
    }
}