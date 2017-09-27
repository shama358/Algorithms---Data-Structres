/* Question
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
    int count = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length == 0) {
            return null;
        }
        return build(preorder,inorder,0, 0, inorder.length - 1);  
    }
    private TreeNode build(int[] preorder, int[] inorder, int loP, int loIn, int 
                           hiIn) {
        //if only 1 node, create & return new node
        if (loIn == hiIn) {
            return new TreeNode(inorder[loIn]);
        }
        TreeNode rootNode = new TreeNode(preorder[loP]);
        //to find the idx of the element in inorder[]
        int root = 0;
        for (int i = loIn; i <= hiIn; ++i) {
            if (inorder[i] == preorder[loP]) {
                root = i;
                break;
            }
        }
        //used for marking the right subtree in postorder[]
        int diff = root - loIn;
        if (inorder[loIn] == preorder[loP]) {
            rootNode.left = null;
        } else {
            rootNode.left = build(preorder, inorder, loP + 1, loIn, root - 1);
        }
        if (inorder[hiIn] == preorder[loP]) {
            rootNode.right = null;
        } else {
            rootNode.right = build(preorder, inorder, loP + diff + 1, root + 1, 
                                   hiIn);
        }
        return rootNode;        
    }
}