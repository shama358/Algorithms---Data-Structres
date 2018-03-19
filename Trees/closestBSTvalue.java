/* Question
Given a non-empty binary search tree and a target value, find the value in the 
BST that is closest to the target.

Note:

Given target value is a floating point.

You are guaranteed to have only one unique value in the BST that is closest to 
the target.

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
    public int closestValue(TreeNode root, double target) {
        return findVal(root, target, root.val);
    }
    private int findVal(TreeNode root, double target, int val) {
        if (root == null) {
            return val;
        }
        if (Math.abs(root.val - target) < Math.abs(val - target)) {
            val = root.val;
        }
        if (root.val > target) {
            return findVal(root.left, target, val);
        } else if (root.val < target) {
            return findVal (root.right, target, val);
        } else {
            return root.val;
        }
    }
}