/**
input: int dividend and divisor
output:  a result of division
constraint: integer range, divisor != 0
requirement: no multiplication, division, mod

clarify:
result is still integer range?
only dividend and divisor between eachother doesn't allow * / % ? 

approach:
bit operation

first handle the overflow case: special negative min value divide by -1
use a negative boolean to mark sign
use bit shifting to calculate result
while dividend >= divisor
shift bit until the max value of k that divisor*2^k smaller or equal than dividend
dividend -= divisor*2^k
res += shifted bit 
return res in int with sign

 */
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        long res = 0;
        boolean negative = (dividend < 0) ^ (divisor < 0);
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        while(a >= b){
            int k = 0;    
            while(b << (k+1) <= a) k++;
            a -= b << k;
            res += 1L <<k;
        }
        return negative ? (int) -res : (int)res;
    }
}