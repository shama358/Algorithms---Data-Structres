/* Question
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
        if (root == null) {
            return res;
        }
        //stack to iterate
        Stack st = new Stack();
        //hashset to keep track of the visited nodes.
        HashSet<TreeNode> visited = new HashSet<TreeNode>();
        postOrder(root, res, st, visited);
        return res;
    }
    private void postOrder(TreeNode root, List<Integer> res, Stack st, 
                           HashSet<TreeNode> visited) {
        //all the left child of the nodes.
        while(root != null) {
            st.push(root);
            root = root.left;
        }
        //pop and check if it has a right subtree. If yes, then call postOrder()
        while(!st.isEmpty()) {
            TreeNode temp = (TreeNode)st.pop();
            if(!visited.contains(temp) && temp.right != null) {
                st.push(temp);
                visited.add(temp);
                postOrder(temp.right, res, st, visited);
            } else {
                visited.add(temp);
                res.add(temp.val);
            }
        }
    }
}