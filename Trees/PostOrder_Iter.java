/*Question
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        //stack to iterate
        Stack st = new Stack();
        //hashset to keep track of the visited nodes.
        HashSet<TreeNode> visited = new HashSet<TreeNode>();
        while(!st.isEmpty() || root != null) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                //if the node has right subtree, iterate and mark as visited.
                TreeNode tmp = (TreeNode)st.peek();
                if (tmp.right != null && !visited.contains(tmp)) {
                    root = tmp.right;
                    visited.add(tmp);
                } else {
                    tmp = (TreeNode)st.pop();
                    res.add(tmp.val);
                }
            }
        }
        return res;
    }
}