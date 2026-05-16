/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) { //List of a list of integers... kill me
        List<List<Integer>> res = new ArrayList<>(); //our result >_>

        Queue<TreeNode> q = new LinkedList<>(); //our queue of tree nodes
        q.add(root); //add the starting root to queue

        while(!q.isEmpty()) { 
            List<Integer> level = new ArrayList<>(); //our levels

            for (int i = q.size(); i > 0; i--) { //find the size of the queue
                TreeNode node = q.poll(); //find values of the node
                if(node != null) { 
                    level.add(node.val); //add a vaue to the level
                    q.add(node.left); //add next nodes to the q
                    q.add(node.right);
                }
            }
            if (level.size() > 0) {
                res.add(level); //add 
            }
        }
        return res;
    }
}
