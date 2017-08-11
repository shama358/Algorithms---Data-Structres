/* Question
A linked list is given such that each node contains an additional random pointer
which could point to any node in the list or null.

Return a deep copy of the list.
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode curr = head;
        //creting new List within the given list.
        while (curr != null) {
            RandomListNode temp = curr.next;
            /* new node will be preceded by its old Node and followed by the 
			next old node. */
            curr.next = new RandomListNode(curr.label);
            curr.next.next = temp;
            curr = temp;
        }
        curr = head;
        //linking the random pointer of the new nodes.
        while (curr != null) {
            RandomListNode newList = curr.next;
            if (curr.random == null) {
                newList.random = null;
            } else {
                newList.random = curr.random.next;
            }
            curr = newList.next;
        }
        curr = head;
        RandomListNode newList = curr.next;
        RandomListNode result = newList;
        //extract new List from the old list and reset links of the old list
        while (curr != null) {
            curr.next = newList.next;
            curr = curr.next;
            if (curr != null) {
                newList.next = curr.next;
                newList = newList.next;
            }
        }
        newList.next = null;
        return result;
    }
}