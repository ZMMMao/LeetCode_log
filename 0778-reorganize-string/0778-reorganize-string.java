/**
Algo: max-heap
Data Structure: max-heap, HashMap, String
TC: O(nlogk)
SC: O(n)
 */
class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> count = new HashMap<>();
        char[] chars = s.toCharArray();
        for(char c : chars){
            count.put(c, count.getOrDefault(c, 0) + 1);
            if(count.get(c) > (chars.length + 1) / 2) return "";
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> count.get(b) - count.get(a));
        for(char key : count.keySet()){
            pq.offer(key);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char first = pq.poll();
            if(sb.length() == 0 || sb.charAt(sb.length() - 1) != first){
                sb.append(first);
                count.put(first, count.get(first) - 1);
            } else{
                char second = pq.poll();
                sb.append(second);
                count.put(second, count.get(second) - 1);
                if(count.get(second) > 0){
                    pq.offer(second);
                }
            }
            
            if(count.get(first) > 0){
                    pq.offer(first);
            }
        }

        return sb.toString();
    }
}