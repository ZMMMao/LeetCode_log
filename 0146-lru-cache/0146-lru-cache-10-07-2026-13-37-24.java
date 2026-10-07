/**
LRUCache class
requirement: get, put is O(1)

clarify: key and value are integers?

API methods: 
1. initialize with capacity
2. get() and put() is O(1) -> hashmap -> map key - node so remove is O(1)
3. update() the value if key exist -> move to the mostRecent, tail of the list -> LinkedList
4. LinkedList: dummy head and tail, addToHead and 
5. remove() remove node
6. evict when reach the capacity

 */
class LRUCache {
    static class Node{
        int key, val;
        Node prev;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    private final Node head = new Node(0,0);
    private final Node tail = new Node(0,0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            node.val = value;
            moveToHead(node);
            return;
        }

        if(map.size() == capacity){
            Node last = tail.prev;
            map.remove(last.key);
            remove(last);
        }

        Node newNode = new Node(key, value);
        addToHead(newNode);
        map.put(key, newNode);
    }

    private void addToHead(Node node){
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    private void moveToHead(Node node){
        remove(node);
        addToHead(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */