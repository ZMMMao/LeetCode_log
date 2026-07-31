/**
maintain a stack with retrieving the minimum element\
1 stack + minvalue
TC: O(1) for ops
SC: O(n)
 */
class MinStack {
    private Deque<Integer> stack;
    private int min;
    public MinStack() {
       stack = new ArrayDeque<>();
       min = Integer.MAX_VALUE; 
    }
    
    public void push(int value) {
        if(min >= value){
            stack.push(min);
            min = value;
        }
        stack.push(value);
    }
    
    public void pop() {
        if(stack.pop() == min){
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */