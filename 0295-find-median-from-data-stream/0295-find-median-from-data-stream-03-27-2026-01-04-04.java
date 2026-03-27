class MedianFinder {
/**
situation:
    median means it can divide the number set into 2 equal pieces.
    2 heap
    try to keep left = right, 
    1. offer right and poll right.peek to left
    2. left > right, offer left, poll left peek to right
 */
 /**
 TC: O(logn) - addNum
 SC: O(n)
  */
    private PriorityQueue<Integer> left; 
    private PriorityQueue<Integer> right; 
    public MedianFinder() {
        left = new PriorityQueue<>((a,b) -> b - a); //max-heap
        right = new PriorityQueue<>(); //min-heap
    }
    
    public void addNum(int num) {
        if(left.size() == right.size()){
            right.offer(num);
            left.offer(right.poll());
        }else{
            left.offer(num);
            right.offer(left.poll());
        }
    }
    
    public double findMedian() {
        if(left.size() > right.size()) return left.peek();
        return (left.peek() + right.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */