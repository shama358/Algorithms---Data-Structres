/* Question
Given a binary tree, collect a tree's nodes as if you were doing this: Collect 
and remove all leaves, repeat until the tree is empty.

Example:
Given binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].

Explanation:
1. Removing the leaves [4, 5, 3] would result in this tree:

          1
         / 
        2          
2. Now removing the leaf [2] would result in this tree:

          1          
3. Now removing the leaf [1] would result in the empty tree:

          []         
Returns [4, 5, 3], [2], [1].
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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        findingLeaves(root, res);
        return res;
    }
    /*calculates the depth of each node (leaves at depth 1), and add the 
    node to the list, where depth - 1 = idex in the array list*/
    private int findingLeaves(TreeNode root, List<List<Integer>> res) {
        //adding the leaves to index 0
        if (root.left == null && root.right == null) {
            if (res.size() == 0) {
                res.add(0, new LinkedList<Integer>());
            }
            res.get(0).add(root.val);
            return 1;
        }
        int left = 0, right = 0;
        if (root.left != null) {
            left = findingLeaves(root.left, res);
        }
        if (root.right != null) {
            right = findingLeaves(root.right, res);
        }
        //calculate the depth of the current node and add it to the list
        int depth = Math.max(left, right) + 1;
        /*if the size of the arraylist < depth, that says that no node has 
        been added corresponding to the depth, so add an empty list and 
        then add the node*/
        if (res.size() < depth) {
            res.add(depth - 1, new LinkedList<Integer>());
        }
        res.get(depth - 1).add(root.val);
        return depth;
    }
}