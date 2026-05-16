/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
       ListNode prev = null; //defines previous node curerntly null
       ListNode curr = head; //defines current node (head)

       while (curr != null) { // While there are nodes to reverse
        ListNode temp = curr.next; // Save the next node
        curr.next = prev;  // Reverse the pointer
        prev = curr; // Move prev forward
        curr = temp; // Move curr forward
       
       }
       return prev;
    }
}
