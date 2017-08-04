/* Question
Given a binary tree, check whether it is a mirror of itself (ie, symmetric
around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
	//passing the root of left and right subtree
        return isSymmetricRec(root.left, root.right);
    }
    private boolean isSymmetricRec(TreeNode rootL, TreeNode rootR) {
        if (rootL == null && rootR == null) {
            return true;
        } else if (rootL == null && rootR != null) {
            return false;
        } else if (rootL != null && rootR == null) {
            return false;
        }
        if (rootL.val != rootR.val) {
            return false;
        }
	//returns true only if the left and right subtree are symmetric
        return isSymmetricRec(rootL.left, rootR.right) && 
		isSymmetricRec(rootL.right, rootR.left);
    }
}
