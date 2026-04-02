/**
input/output:
    - input type: int x
    - input range [2^-31, 2^31 - 1]
    - output int reverse
Edge case: 
    overflow, return 0
Approach:
    - % 10 and add
    - overflow check
TC: O(1)
SC: O(1)
 */
class Solution {
    public int reverse(int x) {
        int res = 0;
        while(x != 0){
            int temp = x % 10;
            if(res > 214748364 || (res == 214748364 && temp > 7)){
                return 0;
            }
            if(res < -214748364 || (res == -214748364 && temp < -8)){
                return 0;
            }
            res = res * 10 + temp;
            x /= 10;
        }
        return res;
    }
}