/* Question
Given a binary search tree and a node in it, find the in-order successor of that 
node in the BST.

Note: If the given node has no in-order successor in the tree, return null.
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return successor(root, p, null);
    }
    
    private TreeNode successor(TreeNode root, TreeNode p, TreeNode succ) {
        if (root == null) {
            return null;
        }
        if (root.val > p.val) {
            return successor(root.left, p, root);
        } else if (root.val < p.val) {
            return successor(root.right, p, succ);
        } else {
            if (root.right != null) {
                return findMin(root.right);
            } else {
                return succ;
            }
        } 
    }
    
    private TreeNode findMin(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return findMin(root.left);
    }
}