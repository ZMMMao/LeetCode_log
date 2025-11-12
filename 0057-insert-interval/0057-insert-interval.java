/**
input: intervals - ascending order by index 0, non-overlapping
        newInterval to insert
output: inserted intervals
input sizez: 0 - 10^4
input range: 0 - 10^5
situation:  1. before new: curr_end < new_start, add curr
            2. overlapping: curr_start <= new_end, merge
            3. rest: curr_start > new_end, add curr
TC: O(n)
SC: O(n)
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        
        while(i < n && intervals[i][1] < newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]); 
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        ans.add(newInterval);

        while(i < n){
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[0][0]);
    }
}