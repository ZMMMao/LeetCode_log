/**
Algo: linear sort, two pointer
Data Structure: array

Timer: 10:26, >= comparison

TC: O(nlogn) -- array sort
SC: O(n)
TestCase:
same intervals
all ovelapping intevals
empty
no overlap
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        res.add(intervals[0]);
        for(int i = 1; i < n; i++){
            int[] curr = intervals[i];
            if(res.getLast()[1] >= curr[0] && res.getLast()[1] < curr[1]){
                res.getLast()[1] = curr[1];
            } else if(res.getLast()[1] < curr[0]){
                res.add(curr);
            }
        }
        int[][] result = new int[res.size()][2];
        int i = 0;
        for(int[] r : res){
            result[i++] = r;
        }

        return result;
    }
}