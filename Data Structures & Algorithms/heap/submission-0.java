class MinHeap {
    private List<Integer> heap;

    // Constructor initializes the heap list with a placeholder at index 0
    public MinHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0); // index 0 is unused to simplify index math (1-based indexing)
    }

    // Inserts a new value into the heap and maintains heap property
    public void push(int val) {
        heap.add(val);              // Add value to the end
        bubbleUp(heap.size() - 1);  // Restore min-heap order by bubbling up
    }

    // Removes and returns the smallest element (root) from the heap
    public Integer pop() {
        if (heap.size() <= 1) return -1;        // Heap is empty
        if (heap.size() == 2) return heap.remove(1); // Only one real element

        int root = heap.get(1); // Smallest element
        heap.set(1, heap.remove(heap.size() - 1)); // Replace root with last element
        if (heap.size() > 1) {
            bubbleDown(1); // Restore heap by bubbling down
        }
        return root;
    }

    // Returns the smallest element without removing it
    public Integer top() {
        return heap.size() > 1 ? heap.get(1) : -1;
    }

    // Builds a heap from an existing list of numbers
    public void heapify(List<Integer> nums) {
        this.heap = new ArrayList<>();
        this.heap.add(0);          // 0th index placeholder
        this.heap.addAll(nums);   // Add all elements

        // Start from the last parent node and bubble down each
        for (int i = heap.size() / 2; i >= 1; i--) {
            bubbleDown(i);
        }
    }

    // Bubbles the element at index up to restore heap property
    private void bubbleUp(int index) {
        int parent = index / 2;
        while (index > 1 && heap.get(parent) > heap.get(index)) {
            swap(index, parent); // Swap if parent is larger
            index = parent;
            parent = index / 2;
        }
    }

    // Bubbles the element at index down to restore heap property
    private void bubbleDown(int index) {
        int child = 2 * index;
        while (child < heap.size()) {
            // Find the smaller child
            if (child + 1 < heap.size() && heap.get(child) > heap.get(child + 1)) {
                child++;
            }

            // If the parent is smaller than the smallest child, we're done
            if (heap.get(child) >= heap.get(index)) break;

            swap(child, index); // Swap with smaller child
            index = child;
            child = 2 * index;
        }
    }

    // Swaps elements at indices i and j in the heap
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
