// Node class for each key-value pair in the hash table
class Node {
    int key;
    int value;
    Node next; // used for chaining in case of collisions

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null; // initially, there's no next node
    }
}

class HashTable {
    private int capacity; // total buckets in the table
    private int size;     // total key-value pairs stored
    private Node[] table; // array of linked lists (buckets)

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new Node[this.capacity]; // initialize empty buckets
    }

    // Hash function: maps a key to a bucket index
    private int hash(int key) {
        return key % this.capacity;
    }

    // Insert or update a key-value pair
    public void insert(int key, int value) {
        int index = this.hash(key);      // Get the bucket index
        Node node = this.table[index];   // Get the linked list head at this bucket

        // If bucket is empty, just insert the node
        if (node == null) {
            this.table[index] = new Node(key, value);
            this.size++;
        } else {
            // Traverse the chain to check for existing key or add to end
            Node prev = null;
            while (node != null) {
                if (node.key == key) {
                    node.value = value; // Update existing key
                    return;
                }
                prev = node;
                node = node.next;
            }
            // Key wasn't found — append to chain
            prev.next = new Node(key, value);
            this.size++;
        }

        // Resize if load factor exceeds 0.5
        if ((double) this.size / this.capacity >= 0.5) {
            this.resize();
        }
    }

    // Retrieve value by key
    public int get(int key) {
        int index = this.hash(key);
        Node node = this.table[index];

        // Traverse chain to find key
        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }

        // Key not found
        return -1;
    }

    // Remove a key-value pair
    public boolean remove(int key) {
        int index = this.hash(key);
        Node node = this.table[index];
        Node prev = null;

        while (node != null) {
            if (node.key == key) {
                if (prev != null) {
                    prev.next = node.next; // skip over the node
                } else {
                    this.table[index] = node.next; // remove head of chain
                }
                this.size--;
                return true;
            }
            prev = node;
            node = node.next;
        }

        // Key not found
        return false;
    }

    // Return number of elements stored
    public int getSize() {
        return this.size;
    }

    // Return current capacity of the table
    public int getCapacity() {
        return this.capacity;
    }

    // Resize and rehash all existing elements
    public void resize() {
        int newCapacity = this.capacity * 2;
        Node[] newTable = new Node[newCapacity];

        // Rehash all nodes from old table
        for (Node node : this.table) {
            while (node != null) {
                int newIndex = node.key % newCapacity;

                // Create a new node for the new table
                Node newNode = new Node(node.key, node.value);

                // Insert at the front of the chain (simpler than traversing)
                newNode.next = newTable[newIndex];
                newTable[newIndex] = newNode;

                node = node.next; // move to next in chain
            }
        }

        // Update table and capacity
        this.capacity = newCapacity;
        this.table = newTable;
    }
}


