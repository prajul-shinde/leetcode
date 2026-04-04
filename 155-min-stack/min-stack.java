class MinStack {

    private Stack<Integer> minstack;
    private Stack<Integer> stack;

    public MinStack() {
        minstack = new Stack<>();
        stack = new Stack();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minstack.isEmpty())
          minstack.push(val);
        else {
            int currentmin = minstack.peek();
            minstack.push(Math.min(currentmin, val));
        }
    }
    
    public void pop() {
        stack.pop();
        minstack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */