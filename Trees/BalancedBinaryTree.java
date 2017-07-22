/*Question

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in 
which the depth of the two subtrees of every node never differ by more than 1.

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
    public boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        int heightDiff = height(root);
        if (heightDiff == -1) {
            return false;
        }
        return true;
    }
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = height(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        boolean heightDiff = subtreeDiff(leftHeight, rightHeight);
        if (heightDiff == false) {
            return -1;
        } 
	//if the heightDiff is less than equal to 1 then increment the height
        return 1 + Math.max(leftHeight, rightHeight);
    }
    private boolean subtreeDiff(int left, int right) {
	//check the height of left and right subtree
        if (Math.abs(left - right) <= 1) {
            return true;
        }
        return false;
    }

}