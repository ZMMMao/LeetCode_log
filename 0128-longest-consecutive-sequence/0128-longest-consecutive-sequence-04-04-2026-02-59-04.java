/**
brute force: sort TC: O(nlogn)
optimal: linear, hashset, TC: O(n)
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }

        int res = 0;
        for(int i : set){
            if(set.contains(i - 1)) continue;
            
            int count = 1;
            while(set.contains(i+1)){
                count++;
                i++;
            }
            res = Math.max(count, res);
        }

        return res;
    }
}