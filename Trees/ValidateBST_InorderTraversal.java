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
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (ValidateBST(root, null) == null) {
            return false;
        }
        return true;
    }
    private TreeNode ValidateBST(TreeNode root, TreeNode prev) {
        if (root.left == null && root.right == null) {
            //when checking the left most leaf of right subtree
            if (prev != null && prev.val >= root.val) {
                return null;
            }
            return root;
        }
        TreeNode left = null, right = null;
        //traverse to left subtree
        if (root.left != null) {
            left = ValidateBST(root.left, prev);
            //check if the root <= any node in left subtree
            if (left == null || root.val <= left.val) {
                return null;
            }
        }
        //traverse to right subtree
        if (root.right != null) {
            right = ValidateBST(root.right, root);
            //return null if the rec returns null
            if (right == null) {
                return null;
            }
        }
        return right == null ? root : right;
    }
}