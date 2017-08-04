/* Question
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most
frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to
the node's key.
The right subtree of a node contains only nodes with keys greater than or equal
to the node's key.Both the left and right subtrees must also be binary search 
trees.

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
		//arr stores the mode at that level
        ArrayList<Integer> arr = new ArrayList<Integer>();
        prevPack res = modeRec(root, p, arr);
		//converting arraylist to an array
        int[] result = new int[arr.size()];
        for (int i = 0; i < arr.size(); ++i) {
            result[i] = arr.get(i);
        }
        return result;
    }
    private prevPack modeRec(TreeNode root, prevPack p, ArrayList<Integer> arr)
	{
        if (root == null) {
            return p;
        }
        prevPack left = modeRec(root.left, p, arr);
		//if root.val == prev.val, increament the count else set the count to 1.
        if (left.prev != null && left.prev.val == root.val) {
            ++left.count;
        } else {
            left.count = 1;
        }
		//if count > max, clear arr and add root.val & max = count
        if (left.count > left.max) {
            left.max = left.count;
            if (!arr.isEmpty()) {
                arr.clear();
            }
            arr.add(root.val);
        } else if (left.count == left.max) {
		//if count == max then add root.val to arr 
            arr.add(root.val);
        }
        left.prev = root;
        prevPack right = modeRec(root.right, left, arr);
        return right;
    }
	/*inner class having the count, previous node and the max number of times a
	value has occured till the current node. */
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