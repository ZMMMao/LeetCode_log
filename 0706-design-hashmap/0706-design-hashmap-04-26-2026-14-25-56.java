class MyHashMap {
    List<int[]>[] buckets;
    private static final int SIZE = 1009; //prime

    public MyHashMap() {
        buckets = new ArrayList[SIZE];
        for(int i = 0; i<SIZE; i++) buckets[i] = new ArrayList<>();
    }
    
    private int hash(int key){ return Math.floorMod(key, SIZE);}

    public void put(int key, int value) {
        for(int[] pair : buckets[hash(key)]){
            if(pair[0] == key){ pair[1] = value; return;}        
        }
        buckets[hash(key)].add(new int[]{key, value});
    }
    
    public int get(int key) {
        for(int[] pair : buckets[hash(key)]){
            if(pair[0] == key) return pair[1];
        }
        return -1;
    }
    
    public void remove(int key) {
        buckets[hash(key)].removeIf(pair -> pair[0] == key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */