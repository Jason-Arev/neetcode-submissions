class KthLargest {

    // Min-heap to keep track of the top k largest elements
    private PriorityQueue<Integer> minHeap;
    private int k;

    // Constructor initializes the class with 'k' and the starting numbers
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        // Add each number to the min-heap
        for (int num : nums) {
            minHeap.offer(num); // Add to heap

            // If heap size exceeds k, remove the smallest element
            // This ensures we only keep the k largest elements
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    // Adds a new value to the stream and returns the k-th largest element
    public int add(int val) {
        minHeap.offer(val); // Add new value

        // If heap size exceeds k again, drop the smallest
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // The root of the min-heap is always the k-th largest element
        return minHeap.peek();
    }
}
