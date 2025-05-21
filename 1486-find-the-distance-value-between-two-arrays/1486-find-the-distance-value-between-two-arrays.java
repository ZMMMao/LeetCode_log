/**
Algo: binary search
Data Structure: array
TC: O(mlogm + nlogm)  // arraySort + binary search
SC: O(1)

Note: decision point: find a target at smallest x-d, if not find, check if the arr2[idx] > x+d
 */
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int res = 0;
        for(int i : arr1){
            int target = i - d;
            int idx = binarySearch(arr2, target);
            if(idx == arr2.length || arr2[idx] > i + d) res++;
        }
        return res;
    }

    public int binarySearch(int[] arr, int target){
        int left = -1;
        int right = arr.length;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) right = mid;
            else left = mid;
        }
        return right;
    }
}