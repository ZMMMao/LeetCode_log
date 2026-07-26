/**
map sorted charArray -- group of anagrams
TC: O(n)
SC: O(n)
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       if(strs == null || strs.length == 0) return new ArrayList<>();

       Map<String, List<String>> map = new HashMap<>(); 
       for(String s : strs){
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        String orderedS = new String(cs);
        map.computeIfAbsent(orderedS, k -> new ArrayList<>()).add(s);
       }

       return new ArrayList<>(map.values());
    }
}