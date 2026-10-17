/**
input: int[][] intervals
output: return an non-overlapping intervals
constraint: intervals.length in [1, 10^4], start and end in 10^4
clarify:
sorted?

approach:
intervals[i] = [start, end]
prev[1] >= curr[0] -> prev[1] = curr[1]
add curr[start, end]

TC: O(nlogn)
SC: O(n)

test case: prev[1] = curr[0]
[1, 2], [2, 3], [5, 7]

res: [1,2]
curr: [2, 3] -> res: [1,3]
curr: [5, 7] -> res: [1,3], [5,7]
result:[[1,3], [5,7]]

follow-up?
if the intervals are meetings, how many rooms do we need?
what if prev.end == curr.start, valid?
count = 1
if prev.end > curr.start -> count++
list of endTimeStamp, if new room added, we add a endTime to it. for next check the whole list if prev.end > curr.start, if false we add or continue;

 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0) return new int[0][];
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            int[] prev = res.get(res.size() - 1);
            if(prev[1] >= curr[0]){
                prev[1] = Math.max(prev[1], curr[1]);
            }else{
                res.add(new int[]{curr[0], curr[1]});
            }
        }
        int[][] result = new int[res.size()][2];
        int index = 0;
        for(int[] a : res){
            result[index++] = a;
        }
        return result;
    }
}