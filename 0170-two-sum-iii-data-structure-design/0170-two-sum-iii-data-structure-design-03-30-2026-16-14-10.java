/**
hashset to save added numbers
find if number contains && target-number contains, return true
TC: O(n) for find, O(1) for add
SC: O(n) for saving numbers
 */
class TwoSum {
    Map<Integer, Integer> numbers;

    public TwoSum() {
        numbers = new HashMap<>();  
    }
    
    public void add(int number) {
        numbers.put(number, numbers.getOrDefault(number, 0) + 1);
    }
    
    public boolean find(int value) {
        for(int n : numbers.keySet()){
            int remain = value - n;
            if(numbers.containsKey(remain)){
                if(remain != n) return true;
                if(numbers.get(n) >= 2) return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */