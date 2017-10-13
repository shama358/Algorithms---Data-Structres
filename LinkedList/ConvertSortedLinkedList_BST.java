/* Question
Given a singly linked list where elements are sorted in ascending order, convert 
it to a height balanced BST.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return constructBST(head);
    }
    private TreeNode constructBST(ListNode head) {
        if (head == null) {
            return null;
        }
        //early exit if there is only 1 node
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        //calculating the length of linkedlist
        int length = size(head);
        if (length % 2 != 0) {
            ++length;
        } 
        int count = 1;
        ListNode curr = head;
        ListNode prev = curr;
        //finding the mid point
        while (count != length / 2 && curr != null) {
            prev = curr;
            curr = curr.next;
            ++count;
        }
        //construct root with mid point for constructing height balanced BST
        TreeNode root = new TreeNode(curr.val);
        /*the linnkedlist left of the mid-point becomes the left subtree of 
        the root an the right part of the mid point becomes the right subtree*/
        ListNode left;
        if (prev != curr) {
            prev.next = null;
            left = head;
        } else {
            left = null;
        }
        ListNode right;
        if (curr != null) {
            right = curr.next;
        } else {
            right = null;
        }
        //call the func recursively to contruct the left and right subtrees.
        root.left = constructBST(left);
        root.right = constructBST(right);
        return root;        
    }
    //returns the length of the linkedlist.
    private int size (ListNode node) {
        if (node == null) {
            return 0;
        }
        int len = 1;
        while (node != null && node.next != null) {
            node = node.next.next;
            len += 2;
        }
        if (node == null) {
            --len;
        }
        return len;
    }
}