/**
minheap + hashmap (string, frequency)
return: list of string, sorted by their lexicographical order
TC: O(nlogk)
SC: O(n)
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if(words == null || words.length == 0) return new ArrayList<>();
        
        Map<String, Integer> freq = new HashMap<>();
        for(String w : words){
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        PriorityQueue<String> minheap = new PriorityQueue<>(
            (a, b) -> freq.get(a).equals(freq.get(b)) 
                        ? b.compareTo(a) 
                        : freq.get(a) - freq.get(b)
        );

        for(String word : freq.keySet()){
            minheap.offer(word);
            if(minheap.size() > k) minheap.poll();
        }

        List<String> res = new LinkedList<>();

        while(!minheap.isEmpty()){
            res.addFirst(minheap.poll());
        }

        return res;
    }

}