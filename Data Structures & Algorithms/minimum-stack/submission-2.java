class MinStack {
    public java.util.ArrayList<Integer> stack;
    public java.util.ArrayList<Integer> minStack;

    public MinStack() {
        stack = new java.util.ArrayList<>();
        minStack = new java.util.ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);

        if (minStack.isEmpty()) {
            minStack.add(val);
        } else {
            int currentMin = minStack.get(minStack.size() - 1);
            minStack.add(Math.min(val, currentMin));
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.remove(stack.size() - 1);
            minStack.remove(minStack.size() - 1);
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return minStack.get(minStack.size() - 1);
    }
}
