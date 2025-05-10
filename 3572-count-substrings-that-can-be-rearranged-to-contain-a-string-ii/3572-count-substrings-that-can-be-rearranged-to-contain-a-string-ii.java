class Solution {
    public long validSubstringCount(String word1, String word2) {
        Map<Character, Integer> count1 = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        for(char c2 : ch2){
            count2.put(c2, count2.getOrDefault(c2, 0) + 1);
        }

        long res = 0;
        int left = 0;
        int count = 0;
        for(int right = 0; right < ch1.length; right++){
            char curr = ch1[right];
            count1.put(curr, count1.getOrDefault(curr, 0) + 1);
            if(count2.containsKey(curr) && count1.get(curr).equals(count2.get(curr))){
                count++;
            }            
            while(left <= right && count >= count2.size()){
                char l = ch1[left];
                count1.put(l, count1.get(l) - 1);
                if(count2.containsKey(l) && count1.get(l) < count2.get(l)) count--;
                left++;
            }
            res += left;
        }
        return res;
    }
}