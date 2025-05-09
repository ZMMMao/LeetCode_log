/**
Algo: heap sort
Data Struc: min-heap with k elements, hashMap for freq of string
TC: O(nlogk)
SC: O(n)

 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        Map<String, Integer> count = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if(count.get(a) == count.get(b)){
                return b.compareTo(a);
            }else{
                return count.get(a) - count.get(b);
            }});
        
        for(String word : words){
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        for(String key : count.keySet()){
            pq.offer(key);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        List<String> res = new LinkedList<>();
        while(!pq.isEmpty()){
            res.addFirst(pq.poll());
        }
        return res;
    }
}