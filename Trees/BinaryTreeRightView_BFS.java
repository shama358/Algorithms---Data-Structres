/* Question
Given a binary tree, imagine yourself standing on the right side of it, return 
the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root == null) {
            return res;
        }
        //BFS traveral
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 1; i <= size; ++i) {
                TreeNode tmp = q.remove();
                /*only the last node at every level will be visible 
                from the right side*/
                if (i == size) {
                    res.add(tmp.val);
                }
                if (tmp.left != null) {
                    q.add(tmp.left);
                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                }
            }
        }
        return res;
    }
}