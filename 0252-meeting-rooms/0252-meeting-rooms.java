/**
Algo: array-sort and check overlap
Data Structure: array
TC: O(nlogn)
SC: O(n)

 */
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i - 1][1] > intervals[i][0]) return false;
        }
        return true;
    }
}