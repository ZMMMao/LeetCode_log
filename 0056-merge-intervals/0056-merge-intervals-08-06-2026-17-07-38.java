/**
if prev_end >= curr_start, update prev_end = max(prev_end, curr_end)
TC: O(nlogn)
SC: O(n)
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null) return new int[0][0];

        List<int[]> res = new ArrayList<>();    
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        res.add(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++){
            int[] prev = res.getLast();
            int[] curr = intervals[i];
            if(prev[1] >= curr[0]){
                prev[1] = Math.max(prev[1], curr[1]);
            }else{
                res.add(new int[]{curr[0], curr[1]});
            }
        }

        return res.toArray(new int[0][0]);
    }
}