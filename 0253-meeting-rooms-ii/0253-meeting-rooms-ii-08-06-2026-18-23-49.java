/**
1. return type: int rooms
2. brute force: for each timeslot, compare to others, get the max of any time
3. TC: O(n^2) SC: O(1)
4. edge case end time = start time, only need 1 room
5. Optimization:
    1. use 2 arrays start and end to calculate conflicts
    2. find max of count
    TC: O(nlogn)
    SC: O(n)
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;

        int n = intervals.length;
        int[] begin = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++){
            begin[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(begin);
        Arrays.sort(end);

        int res = 0;
        int count = 0;
        int i = 0, j= 0;
        while(i < n && j < n){
            if(begin[i] < end[j]){
                count++;
                i++;
            }else{
                count--;
                j++;
            }
            res = Math.max(res, count);
        }

        return res;
    }
}