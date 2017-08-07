/* Question
Given a binary tree containing digits from 0-9 only, each root-to-leaf path
could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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
    public int sumNumbers(TreeNode root) {
        //doing a pre-order tree traversal.
        return sumRec(root, 0);
    }
    private int sumRec(TreeNode root, int leafPath) {
        //early exit
        if (root == null) {
            return 0;
        }
        //early exit when the current node is the leaf node.
        if (root.left == null && root.right == null) {
            if (leafPath != 0) {
              return (leafPath * 10 ) + root.val;  
            }
            return root.val;
        }
        //if the current node is the first node.
        if (leafPath == 0) {
            leafPath = root.val;
        } else {
            //if the current node is not the first node
            leafPath = (leafPath * 10 ) + root.val;
        }
        //traverse the left subtree
        int left = sumRec(root.left, leafPath);
        //traverse the right subtree
        int right = sumRec(root.right, leafPath);
        return left + right;
        
    }
}