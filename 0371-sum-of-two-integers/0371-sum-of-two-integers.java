/**
input/output:
    - int a, b
    - input range: [-1000, 1000]
    - output int
edge case:
    - null return null
Approach:
    - bit operation
    - TC: O(1)
    - SC: O(1)

 */
class Solution {
    public int getSum(int a, int b) {
        while(b != 0){
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}