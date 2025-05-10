/**
Algo: Array sort, map counting anagrams
Data Structure: Array, HashMap
TC: O(n*klogk)
SC: O(n*k)
n is number of strs and k is the average length of each string
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if(!map.containsKey(key)){
                map.put(key, new LinkedList<>());
            } 

            map.get(key).add(s);
        }

        return new LinkedList<>(map.values());
    }
}