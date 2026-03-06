/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

/**
input:
    type: ArrayReader, int
    length: 1, 10^4
    secret[i], target: -10^4, 10^4
output:
    int index or -1
edge case:
    no exist: -1
approach:
    setup right bound = 10^4
    shrink and check if the target exists
    TC: O(logn)
    SC: O(1)
*/

class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 10_000;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(reader.get(mid) == target) return mid;
            if(reader.get(mid) == Integer.MAX_VALUE || reader.get(mid) > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return -1;
    }
}