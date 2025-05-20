/**
Algo: Binary Search
Data Structure: array
TC: O(nlogn)
SC: O(n)
Bug and note: 
 1. long type for spells and potions
 2. potions can/must be sorted to use binary search
 */
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] pairs = new int[spells.length];
        for(int i = 0; i < spells.length; i++){
            long s = spells[i];
            int left = -1;
            int right = potions.length;
            while(left + 1 < right){
                int mid = left + (right - left) / 2;
                long curr = s * potions[mid];
                if(curr >= success) right = mid;
                else{left = mid;}
            }
            pairs[i] = potions.length - right;
        }
        return pairs;
    }
}