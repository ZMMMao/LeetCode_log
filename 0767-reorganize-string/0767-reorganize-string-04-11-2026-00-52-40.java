/**
input: String
output: String
approach: hashMap + heap
TC: O(nlogn)
SC: O(n)
 */
class Solution {
    public String reorganizeString(String s) {
        if(s == null || s.length() == 0) return s;

        int[] count = new int[26];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }

        int n = s.length();
        int max = 0;
        for(int x : count){
            max = Math.max(x, max);
        }
        if(max > (n + 1)/2) return "";

        for(int i = 0; i < 26; i++){
            if(count[i] > 0) maxHeap.offer(new int[]{count[i], i});
        }
        StringBuilder sb = new StringBuilder();

        while(maxHeap.size() >= 2){
            int[] first = maxHeap.poll();
            int[] second = maxHeap.poll();
            sb.append((char)('a' + first[1]));
            first[0]--;
            sb.append((char)('a' + second[1]));
            second[0]--;
            if(first[0] > 0) maxHeap.offer(first);
            if(second[0] > 0) maxHeap.offer(second);
        }

        if(!maxHeap.isEmpty()){
            sb.append((char)('a' + maxHeap.poll()[1]));
        }
        return sb.toString();
    }
}