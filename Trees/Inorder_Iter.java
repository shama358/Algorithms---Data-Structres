/* Question
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        //Stack to store node and iterate in inorder traversal
        Stack st = new Stack();    
        while (!st.isEmpty() || root != null) {
            //push the left nodes in the stack till root != null
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                //pop the top node, add to the list, push right child(if any)
                TreeNode pop = (TreeNode)st.pop();
                res.add(pop.val);
                if (pop.right != null) {
                    root = pop.right;
                }
            }
        }
        return res;
    }
}