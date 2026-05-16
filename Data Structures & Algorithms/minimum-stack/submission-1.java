class MinStack {
    interface Action<T> {
        T perform();
    }

    public java.util.ArrayList<Integer> stack; 
    public java.util.Map<String, Action<?>> minStack; 

    public MinStack() {
        stack = new java.util.ArrayList<>(); //  Initialize stack
        minStack = new java.util.HashMap<>(); //  Initialize map

        
        minStack.put("push", () -> { push(0); return null; }); 
        minStack.put("pop", () -> { pop(); return null; });
        minStack.put("getMin", () -> getMin()); // 
        minStack.put("top", () -> top());   
    }

    public void push(int val) {
        stack.add(val);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.remove(stack.size() - 1);
        }
    }

    public int top() {
        return stack.get(stack.size() - 1); 
    }

    public int getMin() {
        return java.util.Collections.min(stack); 
    }
}
