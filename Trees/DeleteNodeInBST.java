/* Question
Given a root node reference of a BST and a key, delete the node with the given 
key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        int cmp = less (root.val, key);
        //if root is greater than the key
        if (cmp > 0) {
            root.left = deleteNode(root.left, key);
        } else if (cmp < 0) {
            //if root is less than the key
            root.right = deleteNode(root.right, key);
        } else {
            return delete(root);
        }
        return root;
    }
    //delete the node and if the node has any child, return it.
    private TreeNode delete(TreeNode root) {
        TreeNode temp;
        //return null if the node has no child
        if (root.left == null && root.right == null){
            return null;
        } else if (root.right == null) {
            //return the left subtree if there is no right child.
            temp = root.left;
            root.left = null;
        } else if (root.left == null) {
            //return the right subtree if there is no left child.
            temp = root.right;
            root.right = null;
        } else {
            /*if both left and right subchild is present, replace root with 
            immediate left child of right subtree.*/
            temp = root.right;
            TreeNode reallign = temp.left;
            temp.left = root.left;
            if (reallign != null) {
                align (reallign, root.left);
            } 
        }
        return temp;
    }
    /*if the candidate key has a left subtree, attach it to the extreme right of 
	the left child of the given node to be deleted.*/
    private void align(TreeNode sub, TreeNode root) {
        if (root.right == null) {
            root.right = sub;
            return;
        } 
        align(sub, root.right);
    }
    //comapres 2 integer values.
    private int less(int a, int b) {
        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        } else {
            return 0;
        }
    }
}