/* Question
Given a linked list, remove the nth node from the end of list and return its 
head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 
   1->2->3->5.
   1->2->3->5.
Note:
Given n will always be valid.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        int len = 1;
        //find the length of the linkedlist
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            len += 2;
        }
        if (fast == null) {
            --len;
        }
        ListNode slow = dummy;
        int currLen = 0;
        //iterate to the node to be deleted
        while(currLen != len - n) {
            slow = slow.next;
            ++currLen;
        }
        delete(slow, slow.next);
        return dummy.next;        
    }
    //delete the node
    private void delete(ListNode prev, ListNode node) {
        prev.next = node.next;
    }
}