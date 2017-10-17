/* Question
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        //stack for storing the nodes and iterating in preorder fashion
        Stack r = new Stack();
        while(!r.isEmpty() || root != null) {
            //add the root value to the list
            res.add(root.val);
            //if the root has right child then push the right child into stack
            if (root.right != null) {
                r.push(root.right);
            }
            root = root.left;
            //pop from stack when root == null and stack is not empty
            if (root == null && !r.isEmpty()) {
                root = (TreeNode)r.pop();
            }
        }
        return res;
    }
}