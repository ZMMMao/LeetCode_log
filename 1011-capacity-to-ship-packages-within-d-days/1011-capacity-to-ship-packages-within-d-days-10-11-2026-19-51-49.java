/**
input: int days, int[] weights
output: int leastWeight
constraint: 1 <= days <= weights.length <= 5*10^4, weights[i] in [1, 500]

clarify:
weight given by weights' order, fixed? sorted?

approach:
got a global (right) max weight capacity that sum the whole weights
minimum(left) is min(weights)
while (left <= right)
if(canShip(mid, days, weights)) right = mid - 1
else left = mid + 1;
return left;

TC: O(n)
SC: O(n)
*/
/**
test case: 
[3, 2, 2, 4, 1, 4], days = 3

right = 16, left = 5, mid = 10 -> true
right = 9, left = 5, mid = 7 -> true
right = 6, left = 5, mid = 5 -> false, left = mid + 1;
right = 6, left = 6, mid = 6 -> true, right = mid - 1 < left, break

return 6
*/
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        if(weights == null || weights.length == 0 || days == 0) return 0;

        int left = 0;
        int right = 0;
        for(int w : weights){
            right += w;
            left = Math.max(left, w);
        }
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(canShip(mid, days, weights)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    private boolean canShip(int cap, int days, int[] weights){
        int load = 0;
        int totalDays = 1;
        for(int w : weights){
            if(load + w > cap){
                totalDays++;
                load = 0;
                if(totalDays > days) return false;
            }
            load += w;
        }
        return true;
    }
}