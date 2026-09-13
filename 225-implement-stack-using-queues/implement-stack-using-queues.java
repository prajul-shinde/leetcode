class MyStack {

    private Queue<Integer> q;

    public MyStack() {
        q = new ArrayDeque<>();
    }

    // O(N) Time - Rotates queue so new element moves to the front
    public void push(int x) {
        q.add(x);
        int size = q.size();

        // Move all elements that came before x to the back
        for (int i = 0; i < size - 1; i++) {
            q.add(q.poll());
        }
    }

    // O(1) Time - Pops from the front of the queue (top of stack)
    public int pop() {
        return q.poll();
    }

    // O(1) Time - Inspects front element
    public int top() {
        return q.peek();
    }

    // O(1) Time - Checks if queue is empty
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */