/* Question
Serialization is the process of converting a data structure or object into a 
sequence of bits so that it can be stored in a file or memory buffer, or 
transmitted across a network connection link to be reconstructed later in the 
same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is 
no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary search tree can be serialized to a string 
and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your 
serialize and deserialize algorithms should be stateless.

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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder code_s = new StringBuilder();
        //signature of a tree is either postorder or preorder.
        //using preorder in this problem
        preorder(root, code_s);
        return code_s.toString();
        
    }
    //serializing the given tree
    private void preorder(TreeNode root, StringBuilder code) {
        if (root == null) {
            if (code.length() > 0) {
                code.append(",");
            }
            //'#' represents the nulls in the tree
            code.append("#");
            return;
        }
        if (code.length() > 0) {
            code.append(",");
        }
        code.append(Integer.toString(root.val));
        preorder(root.left, code);
        preorder(root.right, code);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] code_deserialize = data.split(",");
        return buildTree(code_deserialize, 0).node;
    }
    //de-serializing the tree and returning the root.
    private helper buildTree(String[] code_deserialize, int idx) {
        //early exit if the current string is null
        if (code_deserialize[idx].equals("#")) {
            return new helper(null, idx);
        }
        //create a new node
        TreeNode node = new TreeNode(Integer.parseInt(code_deserialize[idx]));
        helper left = null, right = null;
        //traverse left only if idx < string length
        if (idx + 1 < code_deserialize.length - 1) {
            left = buildTree(code_deserialize, idx + 1);
        }
        //assign the left link of the node
        if (left != null) {
            node.left = left.node;
            if (left.idx + 1 < code_deserialize.length - 1) {
                right = buildTree(code_deserialize, left.idx + 1);
            }
        }
        //assign right link of the node
        if (right != null) {
            node.right = right.node;
            //return statemenet when right != null
            return new helper(node, right.idx);
        }
        return new helper(node, idx);
    }
    //helper class that contains the created node and the curr idx.
    class helper {
        TreeNode node;
        int idx;
        helper(TreeNode r, int i) {
            node = r;
            idx = i;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));