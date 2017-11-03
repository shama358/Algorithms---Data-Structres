/* Question
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most 
frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to 
the node's key.

The right subtree of a node contains only nodes with keys greater than or equal 
to the node's key.

Both the left and right subtrees must also be binary search trees.

For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].

Note: If a tree has more than one mode, you can return them in any order.
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
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        prevPack p = new prevPack(0);
        //arraylist containing modes.
        ArrayList<Integer> arr = new ArrayList<Integer>();
        prevPack res = modeRec(root, p, arr);
        //creating an array of modes from the arraylist
        int[] result = new int[arr.size()];
        for (int i = 0; i < arr.size(); ++i) {
            result[i] = arr.get(i);
        }
        return result;
    }
    private prevPack modeRec(TreeNode root, prevPack p, ArrayList<Integer> arr){
        if (root == null) {
            return p;
        }
        //traverse left subtree
        prevPack left = modeRec(root.left, p, arr);
        //check if the (prev == curr) & assign values to count accordingly
        if (left.prev != null && left.prev.val == root.val) {
            ++left.count;
        } else {
            left.count = 1;
        }
        //add the node value to arraylist if its count is equal/greater than max
        if (left.count > left.max) {
            left.max = left.count;
            //clear and add the current node value if count > max
            if (!arr.isEmpty()) {
                arr.clear();
            }
            arr.add(root.val);
        } else if (left.count == left.max) {
            arr.add(root.val);
        }
        //root is prev node to the right node.
        left.prev = root;
        //traverse right subtree
        prevPack right = modeRec(root.right, left, arr);
        return right;
    }
    //class containing 
    private class prevPack {
        int count;
        TreeNode prev;
        int max;
        prevPack(int m) {
            count = 1;
            max = m;
            prev = null;
        }
    } 
}