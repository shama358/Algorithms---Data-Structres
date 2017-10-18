/* Question
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next 
right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same 
level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
	
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
//Time Complexity : O(n), Space complexity : O(1); (n =  num of nodes)
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        TreeLinkNode curr_level = root;
        while (curr_level != null) {
            TreeLinkNode curr = curr_level;
            //populating next pointer of the next level from the current level.
            while (curr != null) {
                /*if curr.left != null, then the next of that child points to 
                curr.right */
                if (curr.left != null) {
                    curr.left.next = curr.right;
                }
                /*if curr.right != null, curr.left.next points to curr.next's 
                left child */
                if (curr.right != null) {
                    if (curr.next != null) {
                        curr.right.next = curr.next.left;
                    }
                }
                //moving to the sister node of curr.
                curr = curr.next;
            }
            //moving to the next level.
            curr_level = curr_level.left;
        }
    }
}