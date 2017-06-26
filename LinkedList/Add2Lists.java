/* Question

You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single 
digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the 
number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //early exit
        if (l1 == null || l2 == null) {
            if (l1 == null) {
                return l2;
            } else if (l2 == null) {
                return l1;
            } else {
                return null;
            }
        }
        int carry = 0, sum = 0;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        /* when both l1 and l2 are not null */
        while(l1 != null && l2 != null) {
            sum = 0;
            ListNode curr;
            sum = carry + l2.val + l1.val;
            curr = new ListNode((int)(sum % 10));
            carry = sum / 10;
            head.next = curr;
            head = curr;
            l1 = l1.next;
            l2 = l2.next;
        }
        sum = 0;
        /*when l1 is null */
        if (l1 == null && l2 != null) {
            sum = carry + l2.val;
            ListNode curr = new ListNode((int)(sum % 10));
            head.next = curr;
            curr.next = l2.next;
            return dummy.next;
        } else if (l2 == null && l1 != null) {  //l1 is null
            sum = carry + l1.val;
            ListNode curr = new ListNode((int)(sum % 10));
            head.next = curr;
            curr.next = l1.next;
            return dummy.next;
        } else {   //both are null but carry is not 0;
            if (carry != 0) {
                ListNode curr = new ListNode(carry);
                head.next = curr;
                head = curr;
            }
        }
        return dummy.next;
    }
}