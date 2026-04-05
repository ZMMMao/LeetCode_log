/**
2 heaps: minHeap + maxHeap
minHeap maintain the greater side and maxHeap maintain the smaller side
if size equals, median = both heap's pop() sum / 2;
TC: O(logn) for adding and O(1) for finding
SC: O(n)
 */
class MedianFinder {
    PriorityQueue<Integer> large;
    PriorityQueue<Integer> small;

    public MedianFinder() {
        large = new PriorityQueue<Integer>();
        small = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(small.size() > large.size()){
            small.offer(num);
            large.offer(small.poll());
        }else{
            large.offer(num);
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if(small.size() > large.size()){
            return small.peek();
        }else if(small.size() < large.size()){
            return large.peek();
        }
        
        return (large.peek() + small.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */