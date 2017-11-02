/* Question
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a 
constant space solution?
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
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        MinMax mismatch = BST(root, new MinMax());
        //swapping the swapped elements
        if (mismatch.frst_swp != null && mismatch.sec_swp != null) {
            int temp = mismatch.frst_swp.val;
            mismatch.frst_swp.val = mismatch.sec_swp.val;
            mismatch.sec_swp.val = temp;
        }
    }
    //class comtaining prev node in inorder-traversal and the exchanged nodes.
    private class MinMax {
        TreeNode prev;
        TreeNode frst_swp;
        TreeNode sec_swp;
        MinMax() {
            prev = null;
            frst_swp = null;
            sec_swp = null;
        }
        MinMax(TreeNode n) {
            prev = n;
            frst_swp = null;
            sec_swp = null;
        }
    }
    //inorder traversal.
    private MinMax BST(TreeNode root, MinMax prev) {
        if (root == null) {
            return prev;
        }
        MinMax left = BST(root.left, prev);
        //checking if the nodes are swapped.
        if (left.prev != null) {
            if (left.prev.val > root.val) {
                // If first element has not been found, assign it to prevElement
                if (left.frst_swp == null) {
                    left.frst_swp = left.prev;
                }
                // If first element has been found, assign 2nd element to root
                left.sec_swp = root;
            }
        }
        left.prev = root;
        MinMax right = BST(root.right, left);
        return right;     
        
    }
}