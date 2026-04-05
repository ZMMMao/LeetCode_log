class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sortedS = new String(c);
            map.putIfAbsent(sortedS, new ArrayList<>());
            map.get(sortedS).add(str);
        }

        List<List<String>> res = new ArrayList<>();
        
        for(List<String> list : map.values()){
            res.add(list);
        }

        return res;
    }
}