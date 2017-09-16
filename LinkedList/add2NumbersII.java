/* Question
You are given two non-empty linked lists representing two non-negative integers. 
The most significant digit comes first and each of their nodes contain a single 
digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the 
number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists 
is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //get the size of the 2 lists
        int size1 = size(l1);
        int size2 = size(l2);
        NodeObj addRes;
        //call add func with offset being the difference in size of the lists
        if (size1 > size2) {
            addRes = add(l1, l2, size1 - size2, size2);
        } else {
            addRes = add(l2, l1, size2 - size1, size1);
        }
        if (addRes.carry != 0) {
            ListNode newNode = new ListNode(addRes.carry);
            newNode.next = addRes.curr;
            return newNode;
        }
        return addRes.curr;
    }
    //func that calculates the size
    private int size(ListNode l1) {
        int count = 0;
        while (l1 != null && l1.next != null) {
            l1 = l1.next.next;
            count += 2;
        }
        if (l1 != null && l1.next == null) {
            ++count;
        }
        return count;
    }
    private NodeObj add(ListNode l1, ListNode l2, int offset, int l2Size) {
        if (l1 == null && l2 == null) {
            return new NodeObj(null, 0, 0);
        }
        NodeObj nextNode = new NodeObj(null, 0, 0);
        if (offset != 0) {
            //call func recursively till offset is 0
            nextNode = add(l1.next, l2, offset - 1, l2Size);
        } else {
            /*call recursiveley while traversing through the lists till the 
            end of both the list*/
            nextNode = add(l1.next, l2.next, 0, l2Size);
        }
        /*add from the end nodes and return the curr node, carry and count 
        of nodes added(required 2 lists are of unequal length)*/
        int val = 0;
        if (nextNode.diff >= l2Size) {
            val = l1.val + nextNode.carry;
        } else {
            val = l1.val + l2.val + nextNode.carry;
        }
        ListNode newNode = new ListNode(val % 10);
        newNode.next = nextNode.curr;
        return new NodeObj(newNode, val / 10, nextNode.diff + 1);        
    }
    /*inner class containg the current node(which becomes the next node to 
    the prev node), carry and the count of nodes added so far.*/
    private class NodeObj {
        ListNode curr;
        int carry;
        int diff;
        NodeObj(ListNode curr, int val, int diff) {
            this.curr = curr;
            carry = val;
            this.diff = diff;
        }
    }
}