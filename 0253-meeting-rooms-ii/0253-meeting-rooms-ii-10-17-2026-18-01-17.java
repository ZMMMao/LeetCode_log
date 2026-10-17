/**
input: 
int[][] intervals
output: int rooms
constraint: intervals.length in [1, 10^4] and start,end in [0, 10^6]

clarify:
what if prev.end == curr.start? a room is valid

approach:
when add a new room:
1. prev.end > curr.start
2. no available room (endTime)

all rooms in a list and check list then if not available, add room
TC: O(n*(k+logn))
TC: O(k)
sort first!!!!
only check the earliest endTime -> minHeap
if peek <= curr.start -> re-use, offer new_end
return heap.size()
TC: O(nlogn)
SC: O(n)

 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(! minHeap.isEmpty() && minHeap.peek() <= curr[0]) minHeap.poll();
            minHeap.offer(curr[1]);
        }
        return minHeap.size();
        
    }
}