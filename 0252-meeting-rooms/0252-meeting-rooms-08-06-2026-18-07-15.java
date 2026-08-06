/**
1. return type: boolean
2. brute force: read each timeslot and compare to the others
3. TC: O(n^2) SC: O(1)
4. example/ edge case 
5. optimization: 
    1.sorting the start time
    2. compare end time if overlap return false;
TC: O(nlogn)
SC: O(1)
 */
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return true; // empty room

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] prev = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(prev[1] > curr[0]) return false;
            prev = curr;
        }
        return true;
    }
}