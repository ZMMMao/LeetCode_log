/**
input string[]
output list<list<String>>
hashmap
key as a code, using int[26] to check the same key
value a list of string
TC: O(m*n), n: strs size, m: each string length
SC: O(m*n)
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();
        for(String s : strs){
            String code = encode(s);
            group.putIfAbsent(code, new ArrayList<>());
            group.get(code).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        for(List<String> set : group.values()){
            res.add(set);
        }
        return res;
    }
    private String encode(String s){
        char[] count = new char[26];
        for(char c : s.toCharArray()){
            int curr = c - 'a';
            count[curr]++;
        }
        return new String(count);    
    }
}