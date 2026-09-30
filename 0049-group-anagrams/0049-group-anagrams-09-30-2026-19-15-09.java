/**
restate:
    input: String
    output: list of anagrams
    constraint: str.length: [1, 10^4], strs[i].length: [0, 100], only lowercase letters

clarify:
    only letters, no numbers and lowercase only

 */
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