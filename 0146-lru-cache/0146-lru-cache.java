/**
get O(1) hashMap
put O(1) + time-order: linked list

 */
class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> cache;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    //helper 1
    private void removeNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    //helper 2
    private void addNode(Node node){
        Node nextNode = head.next;

        head.next = node;
        node.next = nextNode;

        nextNode.prev = node;
        node.prev = head;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }

        Node curr = cache.get(key);
        removeNode(curr);
        addNode(curr);
        return curr.value;
    }
    
    public void put(int key, int value) {
        //update branch
        if(cache.containsKey(key)){
            Node curr = cache.get(key);
            curr.value = value;
            removeNode(curr);
            addNode(curr);
            return;
        }

        // check capacity before adding
        if(cache.size() == capacity){
            Node last = tail.prev;
            removeNode(last);
            cache.remove(last.key);
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        addNode(newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */