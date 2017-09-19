/* Question
Given a linked list, reverse the nodes of a linked list k at a time and return 
its modified list.

k is a positive integer and is less than or equal to the length of the linked 
list. If the number of nodes is not a multiple of k then left-out nodes in the 
end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int size = length(head, 0);
        ListNode curr = head;
        ListNode prev = dummy;
        //find the range and reverse list
        while (size >= k && curr != null) {
            int count = 1;
            //find start and end of K - group
            while (curr != null && count != k) {
                curr = curr.next;
                ++count;
            }
            ListNode nxt = curr.next;
            nodes ret = reverse(prev.next, curr);
            prev.next = ret.first;
            ret.last.next = nxt;
            prev = ret.last;
            curr = nxt;
            size -= k;
        }
        return dummy.next;        
    }

    private nodes reverse (ListNode l1, ListNode l2) {
        if (l1 == l2) {
            return new nodes(l1, l1);
        }
        reverseRec(null, l1, l2);
        return new nodes(l2, l1);
    }
    //reverse the K-group nodes
    private void reverseRec(ListNode prev, ListNode l1, ListNode l2) {
        if (l1 == l2) {
            l1.next = prev;
            return;
        }
        ListNode temp = l1.next;
        l1.next = prev;
        reverseRec(l1, temp, l2);        
    }
    //calculate the length the list
    private int length(ListNode head, int size) {
        if (head == null) {
            return size;
        }
        return length(head.next, size + 1);
    }
    class nodes {
        ListNode first;
        ListNode last;
        nodes(ListNode l1, ListNode l2) {
            first = l1;
            last = l2;
        }
    }
}