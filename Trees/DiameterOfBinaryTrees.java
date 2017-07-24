/* Question
Given a binary tree, you need to compute the length of the diameter of the tree. 
The diameter of a binary tree is the length of the longest path between any two 
nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges 
between them.
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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //MaxDia max = new MaxDia();
        MaxDia max = MaxDiaRec(root);
        return max.dia - 1;
    }
    //return the height and the diameter of the subtrees.
    private MaxDia MaxDiaRec(TreeNode root) {
       MaxDia max = new MaxDia(); 
       if (root == null) {
           return max;
       }
        MaxDia left = MaxDiaRec(root.left);
        MaxDia right = MaxDiaRec(root.right);
        //max height passed to the prev nodes to find the dia at that node.
        max.height = Math.max(left.height, right.height) + 1;
        /* returning max dia by comparing the dia of the left and right subtree 
        and also the dia at the current node.*/
        max.dia = Math.max(left.dia, right.dia);
        max.dia = Math.max(max.dia, left.height + right.height + 1);
        return max;
    } 
    //class for keeping track of the max-height and max-dia of the tree.
    private class MaxDia {
        int dia;
        int height;
        MaxDia () {
            dia = 0;
            height = 0;
        }
    }
    
}