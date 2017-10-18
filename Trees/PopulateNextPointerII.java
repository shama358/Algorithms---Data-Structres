/* Question
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution 
still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        /* populate the next pointer in the current level*/
        //dummy node
        TreeLinkNode prev = new TreeLinkNode(0);
        //cur keeps track of the first node in the current level
        TreeLinkNode cur_level = prev;
        while (root != null) {
            //asigning the next of prev to the current sibling node
            if(root.left != null) {
                prev.next = root.left;
                prev = root.left;
            }
            if (root.right != null) {
                prev.next = root.right;
                prev = root.right;
            }
            //go to the next node of the root in the same level.
            root = root.next;
        }
        //call recursively with the first node of next level
        connect(cur_level.next);
    }
}