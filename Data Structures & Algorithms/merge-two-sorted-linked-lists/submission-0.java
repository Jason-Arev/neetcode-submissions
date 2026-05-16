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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode clone = new ListNode(0); //makes a node head before starting
        ListNode node = clone; //create moving pointer
        while(list1 != null && list2 != null) { //runs while neither list is null
            if (list1.val < list2.val) {
                node.next = list1; //list1 is next if lower number
                list1 = list1.next; //rechecks vals of list 1
            } else {
                node.next = list2; //list2 is next if val is lower
                list2 = list2.next; //rechecks val of list 2
            }
            node = node.next; //points at the next node
        }
        if (list1 != null) {
            node.next = list1;
        } else {
            node.next = list2;
        }
        return clone.next; //return original head
    }
}