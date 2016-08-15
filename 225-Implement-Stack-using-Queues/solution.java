class MyStack {
    // Push element x onto stack.
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    
    public void push(int x) {
        q1.add(x);
    }

    // Removes the element on top of the stack.
    public void swap() {
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public void moveItems() {
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
    }
    
    public void pop() {
        moveItems();
        q1.poll();
        swap();
    }

    // Get the top element.
    public int top() {
        moveItems();
        int temp = q1.poll();
        swap();
        q1.add(temp);
        
        return temp;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}