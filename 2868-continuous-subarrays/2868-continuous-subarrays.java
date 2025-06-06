/**
Algo: linear sorting
Data Structure: deque
TC: O(n)
SC: O(n)
 */
class Solution {
    public long continuousSubarrays(int[] nums) {
        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();

        long res = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            int curr = nums[right];
            while(!min.isEmpty() && nums[min.peekLast()] > curr){
                min.pollLast();
            }
            min.addLast(right);
            while(!max.isEmpty() && nums[max.peekLast()] < curr){
                max.pollLast();
            }
            max.addLast(right);
            while(!max.isEmpty() && !min.isEmpty() && Math.abs(nums[max.peekFirst()] - nums[min.peekFirst()]) > 2){
                while(min.peekFirst() <= left) min.pollFirst();
                while(max.peekFirst() <= left) max.pollFirst();
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}
/**

Note: PQ Solution slow but strightforward

Algo: linear sorting
Data Structure: array，hashMap, 2 pq
TC: O(nlogn)
SC: O(n)

Map<Long, Integer> count = new HashMap<>();
        PriorityQueue<int[]> min = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> max = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        long res = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            long curr = nums[right];
            count.put(curr, count.getOrDefault(curr, 0) + 1);
            min.offer(new int[]{nums[right], right});
            max.offer(new int[]{nums[right], right});
            
            while(!min.isEmpty() && !max.isEmpty() && Math.abs(max.peek()[0] - min.peek()[0]) > 2){
                long l = nums[left];
                count.put(l, count.get(l) - 1);
                if(count.get(l) == 0){
                    if(min.peek()[0] == l){
                        min.poll();
                    } else if(max.peek()[0] == l){
                        max.poll();
                    }
                }
                while(!min.isEmpty() && min.peek()[1] <= left) min.poll();
                while(!max.isEmpty() && max.peek()[1] <= left) max.poll();
                left++;
            }
            res += right - left + 1;
        }
        return res;


 */