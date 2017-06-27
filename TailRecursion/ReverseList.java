/* Question

Reverse a singly linked list.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            //Early termination incase the List has 0 or 1 node
            return head;
        }
        ListNode nextNode = head.next; //A node referencing the next node
        head.next = null;
        return reverseList(head, nextNode);
    }
    public ListNode reverseList(ListNode head, ListNode curr) {
        //Tail recursive function to reverse the references of the nodes.
        if (curr == null) {
            return head;
        }
        ListNode nextToNext = curr.next;
        curr.next = head;
        return reverseList(curr, nextToNext);
    }
}