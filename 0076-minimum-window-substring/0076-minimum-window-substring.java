/**
input String s, t
input size  1 - 10^5
output String minimum
TC: O(m)
SC: O(m)
 */
class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        int m = s.length();
        int n = t.length();
        Map<Character, Integer> countT = new HashMap<>();
        
        for(char c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        int left = 0, right = 0;
        String min = "";
        while(right < s.length()){
            char curr = s.charAt(right);
            if(countT.containsKey(curr)){
                countT.put(curr, countT.get(curr) - 1);
                if(countT.get(curr) == 0) count++;
            }

            while(count == countT.size()){
                if(min.equals("") || min.length() > right - left + 1){
                    min = s.substring(left, right+1);
                }
                char l = s.charAt(left);
                if(countT.containsKey(l)){
                    countT.put(l, countT.get(l) + 1);
                    if(countT.get(l) >0){
                        count--;
                    }
                }
                left++;
            }
            right++;
        }
        return min;
    }
}