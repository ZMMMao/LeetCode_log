/**
Algo: max heap and min heap
TC: O(logn)
SC: O(n)

 */
class MedianFinder {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(small.size() >= large.size()){
            small.offer(num);
            large.offer(small.poll());
        }else{
            large.offer(num);
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        double median = 0;
        if(small.size() > large.size()){
            median = small.peek();
        }else if(small.size() < large.size()){
            median = large.peek();
        }else{
            median = (small.peek() + large.peek())/2.0;
        }
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */