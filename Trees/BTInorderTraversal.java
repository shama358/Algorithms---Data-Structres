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
    public List<Integer> inorderTraversal(TreeNode root) {
        //contains the result
        List<Integer> list = new ArrayList<Integer>();
        //contains the nodes traversed
        Stack<TreeNode> stack = new Stack<TreeNode>();
        return inorderTraversal(root, list, stack);
    }
    private List<Integer> inorderTraversal(TreeNode cur, List<Integer> list, 
	Stack<TreeNode> stack) {
        //pop the top element of the stack and add the right subtree if present
        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }

}