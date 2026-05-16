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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Boolean> visited = new Stack<>();
        List<Integer> res = new ArrayList<>(); //prints our result

        stack.push(root); //push root onto stack and declare unvisited
        visited.push(false);

        while (!stack.isEmpty()) { 
            TreeNode curr = stack.pop(); 
            boolean v = visited.pop(); 

            if (curr != null) { //ignores nulls
                if (v) { //if curr is true, add to the result
                    res.add(curr.val);
                } else {
                    stack.push(curr); //if not visited yet but is curr, 
                    visited.push(true); //and declare true
                    stack.push(curr.right); //add the right node and declare false
                    visited.push(false); 
                    stack.push(curr.left); // add left node as false, and next curr
                    visited.push(false);
                }
            }
        }
        return res;
    }
}