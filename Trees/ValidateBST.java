/* Question
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's 
key.
The right subtree of a node contains only nodes with keys greater than the 
node's key.
Both the left and right subtrees must also be binary search trees.
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
        //ValidBSTRec() return null only if the given tree is not BST
        if (ValidBSTRec(root) != null) {
            return true;
        }
        return false;
    }
    private levelMinMax ValidBSTRec(TreeNode root) {
        //for the leaf node, the node itself is the max and the min
        if (root.left == null && root.right == null) {
            return new levelMinMax(root.val, root.val);
        }
        levelMinMax left = null, right = null;
        //if there is a left subtree
        if (root.left != null) {
            left = ValidBSTRec(root.left);
            //check if the max in the left subtree is greater than the root node.
            if ((left != null && left.max >= root.val) || (left == null)) {
                return null;
            }
        }
        //if there is a right sub tree
        if (root.right != null) {
            right = ValidBSTRec(root.right);
            //check if the min in the right subtree is less than the root.
            if ((right != null && right.min <= root.val) || (right == null)) {
                return null;
            }
        }
        //return the max and min at that level
        if (right != null && left != null) {
            return new levelMinMax (Math.max(root.val, right.max), 
			                        Math.min(root.val, left.min));
        } else if (right == null){
            return new levelMinMax(root.val, Math.min(root.val, left.min));
        } else {
            return new levelMinMax((Math.max(root.val, right.max)), root.val);
        }
    }
    private class levelMinMax {
        int max;
        int min;
        levelMinMax(int a, int b) {
            max = a;
            min = b;
        }
    }
}