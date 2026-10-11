/**
input: 
int[] piles, int h
output:
    int k, eating rate for finish all piles in h
constraint:
1 <= piles.length <= h <= 10^4
piles i in [1, 10^9]

clarify:
piles is sorted or not?
piles.length is guaranteed to be smaller than h
each hour Koko can only eat one of the piles and finish bananas equal less than k.

approach:
find the largest reasonable k -> max number of one pile, finished in pile.length
minimum speed is 0
find the minimum between[0, k_max]
canFinish as a helper, try if it can finish in h
 */
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(piles == null || piles.length == 0) return 0;
        int max = 0;
        for(int p : piles){
            max = Math.max(p, max);
        }

        int left = 1;
        int right = max;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(canFinish(mid, piles, h)) right = mid - 1;
            else{
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean canFinish(int k, int[] piles, int h){
        long count = 0;
        for(int p : piles){
            count += p/k;
            if(p % k > 0) count++;
            if(count > h) return false;
        }
        return true;
    }
}