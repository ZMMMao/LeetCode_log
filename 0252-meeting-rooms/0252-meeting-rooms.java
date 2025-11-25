/**
input/output:
    - input: int[][] intervals
    -input length: [0, 10^4]
    -input range: [0, 10^5]
    -output boolean isValid
edge case: 
    - 0 return true
Approach:
    sweep to check overlaps
    - sort with start
    - check prev end and curr start ovelapping
    TC: O(nlogn)
    SC: O(1)
 */
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0) return true;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int curr = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < curr) return false;
            curr = intervals[i][1];
        }
        return true;
    }
}