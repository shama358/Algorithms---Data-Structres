/* Question
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

1. The left subtree of a node contains only nodes with keys less than the node's 
key.
2. The right subtree of a node contains only nodes with keys greater than the 
node's key.
3. Both the left and right subtrees must also be binary search trees.


Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.

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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return ValidateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean ValidateBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }
        if ((root.val == Integer.MIN_VALUE && root.left != null) || 
            (root.val == Integer.MAX_VALUE && root.right != null)) {
            return false;
        }
        return ValidateBST(root.left, min, root.val - 1) && 
            ValidateBST(root.right, root.val + 1, max);
    }
}