// Binary Search Tree Node
class TreeNode {
    int key;        // Key used for ordering (BST property)
    int val;        // Value associated with the key
    TreeNode left;  // Left child (smaller keys)
    TreeNode right; // Right child (larger keys)

    public TreeNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

// Binary Search Tree-based Map implementation
class TreeMap {
    private TreeNode root;

    // Constructor: creates an empty TreeMap
    public TreeMap() {
        root = null;
    }

    // Inserts a key-value pair into the tree
    // If key exists, update the value
    public void insert(int key, int val) {
        TreeNode newNode = new TreeNode(key, val);
        if (root == null) {
            root = newNode;
            return;
        }

        TreeNode current = root;
        while (true) {
            if (key < current.key) {
                // Go left
                if (current.left == null) {
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else if (key > current.key) {
                // Go right
                if (current.right == null) {
                    current.right = newNode;
                    return;
                }
                current = current.right;
            } else {
                // Key exists → update value
                current.val = val;
                return;
            }
        }
    }

    // Returns the value for a given key, or -1 if not found
    public int get(int key) {
        TreeNode current = root;
        while (current != null) {
            if (key < current.key) {
                current = current.left;
            } else if (key > current.key) {
                current = current.right;
            } else {
                return current.val;
            }
        }
        return -1;
    }

    // Returns the value of the smallest key in the tree
    public int getMin() {
        TreeNode current = findMin(root);
        return (current != null) ? current.val : -1;
    }

    // Helper to find the node with the smallest key (leftmost node)
    private TreeNode findMin(TreeNode node) {
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Returns the value of the largest key in the tree
    public int getMax() {
        TreeNode current = root;
        while (current != null && current.right != null) {
            current = current.right;
        }
        return (current != null) ? current.val : -1;
    }

    // Removes a key from the tree if it exists
    public void remove(int key) {
        root = removeHelper(root, key);
    }

    // Recursive helper to remove a node with a specific key
    private TreeNode removeHelper(TreeNode curr, int key) {
        if (curr == null) return null;

        if (key > curr.key) {
            curr.right = removeHelper(curr.right, key);
        } else if (key < curr.key) {
            curr.left = removeHelper(curr.left, key);
        } else {
            // Node found
            if (curr.left == null) return curr.right; // No left child
            if (curr.right == null) return curr.left; // No right child

            // Two children: replace with inorder successor (fills in the space if the removed node had children)
            TreeNode minNode = findMin(curr.right);
            curr.key = minNode.key;
            curr.val = minNode.val;
            curr.right = removeHelper(curr.right, minNode.key);
        }

        return curr;
    }

    // Returns the keys in sorted (inorder) order
    public List<Integer> getInorderKeys() {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    // Recursive inorder traversal (Left → Root → Right)
    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            inorderTraversal(root.left, result);
            result.add(root.key);
            inorderTraversal(root.right, result);
        }
    }
}
