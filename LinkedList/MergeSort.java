/* Question : 
Sort a linked list in O(n log n) time using constant space complexity.
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 //Merge-Sort
 
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next, slow = head;
        //head-slow sub-list 1 and slow.next-tail is sub-list 2; 
        while(fast != null && fast.next != null) {  
        /* the slow reference helps in dividing the linked list into 
        approximately equal sub lists. */
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode node = slow.next;
        slow.next = null; //dividing 1 list into 2 lists.
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(node);
        return merge(h1, h2);
    }
    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);  //dummy node to help with the merge.
        ListNode curr = dummy;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                curr.next = h1;
                h1 = h1.next;
            }else {
                curr.next = h2;
                h2 = h2.next;
            }
            curr = curr.next;
        }
        if (h1 == null) {
            curr.next = h2;
        }
        if (h2 == null) {
            curr.next = h1;
        }
        return dummy.next; 
		//return the first node, i.e., smallest out of h1 and h2 lists.
        
    }
 
}