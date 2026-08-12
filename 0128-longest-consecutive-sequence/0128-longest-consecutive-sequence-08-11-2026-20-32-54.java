/**
unsorted
int[]
return length of longest consecutive sequence
O(n), so no sorting
brute force:
    quick sort O(nlogn)
optimal:
    set + lookup the set
    TC: O(n)
    SC: O(n)
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        Set<Integer> num = new HashSet<>();
        for(int n : nums) num.add(n);

        int count = 0;
        
        for(int i : num){
            if(num.contains(i-1)) continue;
            int curr = 1;
            while(num.contains(i + 1)){
                curr++;
                i++;
            }
            count = Math.max(count, curr);
        }

        return count;
    }
}