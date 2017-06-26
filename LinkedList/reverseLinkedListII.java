/* Question
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ? m ? n ? length of list.

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m - n == 0) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        // prev = node before the sublist to be reversed.
        for (int i = 0; i < m - 1; ++i) {
            prev = prev.next;
        }
        //tail = tail of the new reversed sub list
        ListNode tail = pre.next;
        for (int i = m; i < n + 1; ++i) {
            tail = tail.next;
        }
        prev.next = reverse(prev.next, tail);
        return dummy.next;
    }
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode currNext = head.next;
        head.next = tail;
        while (currNext.next != tail) {
            ListNode nextToNext = currNext.next;
            currNext.next = head;
            head = currNext;
            currNext = nextToNext;
        }
        currNext.next = head;
        return currNext;
        
    }
}