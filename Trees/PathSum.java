/* Question
Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathRec(root, sum, 0);
    }
    private boolean hasPathRec(TreeNode root, int k, int sum) {
        if (root == null) {
            return false;
        }
        //calculate the sum including the current root
        int currSum = sum + root.val;
        //check if the currSum has path starting from root to leaf.
        if (currSum == k && (root.left == null && root.right == null)) {
            return true;
        } 

        if (hasPathRec(root.left, k, currSum)) {
            return true;
        } else if (hasPathRec(root.right, k, currSum)) {
            return true;
        }
        return false;
    }
}