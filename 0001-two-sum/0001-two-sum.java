/**
algo: linear sorting
data structure: hashMap
tc: O(n)
sc: O(n)

test case:
empty
same number
very large number
negative 
mixed negative + positive
0
sorted
reverse sorted
many set of duplicate number
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idx = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int need = target - nums[i];
            if(idx.containsKey(need)){
                return new int[]{i, idx.get(need)};
            }
            idx.put(nums[i], i);
        }
        return new int[2];
    }
}