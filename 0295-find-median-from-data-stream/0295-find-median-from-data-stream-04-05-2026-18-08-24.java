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
        small.offer(num); // keep small side hold the median, lazy
        large.offer(small.poll());

        if(large.size() > small.size()) small.offer(large.poll());
    }
    
    public double findMedian() {
        if(small.size() > large.size()) return small.peek();
        return (large.peek() + small.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */