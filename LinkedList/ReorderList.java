/*

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head, fast = head.next.next;
        if (fast == null) {
            return;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverse(slow.next);
        /*now half the list is as given and the other half is reversed */
        ListNode mid = slow;
        fast = slow.next;
        if (head.next == fast && fast.next.next == null) {
            return;
        }
        slow = head;
        /* moving the positions of the reversed nodes and placeing them 
        in-between the first half of the list */
        while(fast.next != null && slow != mid) {
           mid.next = fast.next;
           fast.next = slow.next;
           slow.next = fast;
           slow = fast.next;
           fast = mid.next;
        }
    }
    
    /* reverse from head.next */
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode currNext = head.next;
        head.next = null;
        while (currNext.next != null) {
            ListNode temp = currNext.next;
            currNext.next = curr;
            curr = currNext;
            currNext = temp;
        }
        currNext.next = curr;
        return currNext;
    }
}