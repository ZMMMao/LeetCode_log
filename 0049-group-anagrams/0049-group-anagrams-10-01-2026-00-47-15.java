/**
restate:
    input: String
    output: list of anagrams
    constraint: str.length: [1, 10^4], strs[i].length: [0, 100], only lowercase letters

clarify:
    only letters, no numbers and lowercase only

approach:
    brute force: sort each string by its char array, use hashMap to map origin string
    TC: O(n*LlogL)
    SC: O(n*L) for hashMap

    optimal:
    encode helper function
    TC: O(n*L)
    SC: O(n*L)
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            String sorted = encode(s);
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    private String encode(String s){
        char[] cs = new char[26];
        for(char c : s.toCharArray()){
            cs[c - 'a']++;
        }
        return new String(cs);
    }
}