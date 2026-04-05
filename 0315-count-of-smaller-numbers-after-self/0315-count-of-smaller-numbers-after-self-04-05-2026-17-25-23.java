/**
Merge sort variant
use pair class to track index
Pros comparing to hashmap:
    1. no overhead(hashing, boxing)
    2. handle duplicates
use count int[] to check index and save in list as result
TC: O(nlogn)
SC: O(n)
 */
class Solution {
    class Pair{
        int num;
        int idx;
        Pair(int num, int idx){
            this.num = num;
            this.idx = idx;
        }
    }

    private Pair[] temp;
    private int[] count;

    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();

        int n = nums.length;
        temp = new Pair[n];
        count = new int[n];
        Pair[] arr = new Pair[n];

        for(int i = 0; i < nums.length; i++){
            arr[i] = new Pair(nums[i], i);
        }
        
        mergeSort(arr, 0, nums.length - 1);

        List<Integer> res = new ArrayList<>();
        for(int c : count) res.add(c);
        return res;
    }

    private void mergeSort(Pair[] arr, int left, int right){
        if(left >= right) return;
        int mid = left + (right-left)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    private void merge(Pair[] arr, int left, int mid, int right){

        for(int i = left; i <= right; i++){
            temp[i] = arr[i];
        }

        int i = left, j = mid+1;
        for(int k = left; k <= right; k++){
            if(i == mid + 1){
                arr[k] = temp[j++];
            }else if(j == right + 1){
                arr[k] = temp[i++];
                count[arr[k].idx] += j - mid - 1;
            }else if(temp[i].num > temp[j].num){
                arr[k] = temp[j++];
            }else{
                arr[k] = temp[i++];
                count[arr[k].idx] += j - mid - 1;
            }
        }
    }
}