class LRUCache {

    // This will store key-value pairs using LinkedHashMap (with access order)
    private final Map<Integer, Integer> cache;

    // Max number of entries the cache can hold
    private final int capacity;

    // Constructor: initialize cache with custom LinkedHashMap
    public LRUCache(int capacity) {
        this.capacity = capacity;

        // Create a LinkedHashMap that maintains *access-order* (not insertion-order)
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {

            // This method gets automatically called *after* every put()
            // If it returns true, the oldest (least recently used) item is removed
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                // If cache size exceeds the limit, remove the eldest (LRU) entry
                return size() > LRUCache.this.capacity;
            }
        };
    }

    // Try to get the value for a key
    // If not found, return -1
    // Also, accessing this key bumps it to the "most recently used" spot
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    // Put or update a key-value pair
    // If the key already exists, it updates and moves it to the most recently used spot
    // If capacity is exceeded, LRU key gets removed automatically (via removeEldestEntry)
    public void put(int key, int value) {
        cache.put(key, value);
    }
}
