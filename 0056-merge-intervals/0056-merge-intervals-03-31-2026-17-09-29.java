/**
intervals
1. prev-end > curr_end, prev cover curr
2. prev-end > curr-start but < curr-end merge prev-end = curr-end
Sort first
TC: O(nlogn)
SC: O(1)
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0) return intervals;

        int n = intervals.length;
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        res.add(intervals[0]);

        for(int i = 1; i < n; i++){
            int[] curr = intervals[i];
            int[] prev = res.getLast();
            if(prev[1] < curr[0]){
                res.add(curr);
            }else{
                if(prev[1] >= curr[1]) continue;
                prev[1] = curr[1];
            }
        }

        return res.toArray(new int[0][0]);
    }
}