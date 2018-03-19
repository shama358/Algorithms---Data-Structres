/* Question
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
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
    public List<String> binaryTreePaths(TreeNode root) {
        //early exit condition
        if (root == null) {
            return new ArrayList<String>();
        }
        List<String> res = new ArrayList<String>();
        root_leaf_path(root, res, new String());
        return res;
    }
    //have used String, as String Builder will require the previous added elements 
    //to be removed while going back to the called function
    private void root_leaf_path(TreeNode root, List<String> res, String interRes) {
        //append the leaf and store the string in the list
        if (root.left == null && root.right == null) {
            interRes = interRes.concat(Integer.toString(root.val));
            res.add(new String(interRes));
            return;
        }
        //concat the current node value and rec call left and right subtree
        interRes = interRes.concat(Integer.toString(root.val)).concat("->");
        if (root.left != null) {
            root_leaf_path(root.left, res, interRes);
        }
        if (root.right != null) {
            root_leaf_path(root.right, res, interRes);
        }
    }
}