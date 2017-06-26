/*
Merge k sorted linked lists and return it as one sorted list. 
Analyze and describe its complexity.

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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode curr = new ListNode(0);
        ListNode mergeLists = curr;
        if (lists.length == 0 || lists == null) {
            return null;
        }
		/* Min heap using a comparator */
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>
		(lists.length, new Comparator<ListNode>() {
                    public int compare(ListNode l1, ListNode l2) {
                        if (l1.val < l2.val) {
                            return -1;
                        } else if (l1.val > l2.val) {
                            return 1;
                        }else {
                            return 0;
                        }
                    }
         });
		 /* populating the Min Heap */
         for (int i = 0; i < lists.length; ++i) {
             if (lists[i] != null) {
                minHeap.add(lists[i]);
             }
         }
         /* merging the K lists by popping out the head of the priority queue 
		 and adding the next node of the popped element */
        while(minHeap.peek() != null) {
            ListNode temp = minHeap.poll();
            curr.next = temp;
            curr = curr.next;
            if (temp.next != null) {
                minHeap.add(temp.next);
            }
        }
        return mergeLists.next;
    }
}