/*Question
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
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
public class Solution {
    public void flatten(TreeNode root) {
        FlattenRec(root, new PrevNode());
        return;
    }
    private void FlattenRec(TreeNode root, PrevNode prev) {
        if (root == null) {
            return;
        }
        //precess the right subtree, left subtree and then the root.
        FlattenRec(root.right, prev);
        FlattenRec(root.left, prev);
        //set the current.right = prev and current.left = null
        root.right = prev.prev;
        root.left = null;
        prev.prev = root;
        return;
    }
    //Object used as Java is pass by value and to avoid class memeber.
    private class PrevNode {
        //has the previous node of the current node.
        TreeNode prev;
        PrevNode() {
            prev = null;
        }
    }
}