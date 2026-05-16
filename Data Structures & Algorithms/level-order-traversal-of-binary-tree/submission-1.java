class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Final result: list of levels, where each level is a list of node values
        List<List<Integer>> res = new ArrayList<>();

        // Edge case: if tree is empty, return empty list
        if (root == null) return res;

        // Queue to hold nodes level by level (BFS)
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root); // Start with the root node

        while (!q.isEmpty()) {
            // Prepare a new list to hold all values at the current level
            List<Integer> level = new ArrayList<>();

            // Only process nodes currently in the queue (this is the current level)
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll(); // Remove the front node from the queue

                // Add the node's value to the current level list
                level.add(node.val);

                // Add child nodes to the queue for the next level
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            // Add the current level to the result
            res.add(level);
        }

        return res;
    }
}
