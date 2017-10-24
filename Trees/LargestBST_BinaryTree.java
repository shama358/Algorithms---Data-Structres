/* Question
Given a Binary Tree, write a function that returns the size of the largest 
subtree which is also a Binary Search Tree (BST). If the complete Binary Tree is 
BST, then return the size of whole tree.

*/

// Java program to find largest BST subtree in given Binary Tree

class Node {

	int data;
	Node left, right;

	Node(int d) {
		data = d;
		left = right = null;
	}
}


class BinaryTree {

	static Node root;

	/* Returns size of the largest BST subtree in a Binary Tree
	(efficient version). */
	int largestBST(Node node) {

		MinMax ret = largestBSTUtil(node);

		return ret.maxC;
	}
	private MinMax largestBSTUtil(Node node) {
	    //if leaf, return the maxC as 1.
	    if (node.right == null && node.left == null) {
	        return new MinMax(node.data, node.data, 1);
	    }
	    MinMax right = null, left = null;
	    //find if BST exist in the left subtree
	    if (node.left != null) {
	        left = largestBSTUtil(node.left);
	        //reset the count as 0 if not BST
	        if (left.count == 0 || left.max > node.data) {
	            return new MinMax(left.min, left.max, 0, left.maxC);
	        }
	    }
	    //find if BST exists in right subtree
	    if (node.right != null) {
	        right = largestBSTUtil(node.right);
	        //reset the count as 0 if not BST
	        if (right.count == 0 || right.min < node.data) {
	            return new MinMax(right.min, right.max, 0, right.maxC);
	        }
	    }
	    //if left and right subtree are BST then return 
		//					count = left.count + right.count + 1
	    // if left or right subtree is not BST then the count will be reset to 0.
	    if (left != null && right != null) {
	        if (left.count != 0 && right.count != 0) {
	            return new MinMax(Math.min(right.min, Math.min(left.min, 
																	node.data)), 
	                Math.max(right.max, Math.max(left.max, node.data)), 
	                left.count + right.count + 1, 
	                Math.max(left.maxC, Math.max(right.maxC, left.count + 
															right.count + 1)));
	        } else if (left.count == 0 && right.count == 0) {
	           return new MinMax(Math.min(right.min, Math.min(left.min, 
																node.data)),
	                Math.max(right.max, Math.max(left.max, node.data)), 0,
	                Math.max(left.maxC, right.maxC));
	        } else if (left.count == 0) {
	            return new MinMax(right.min, right.max, 0, right.maxC);
	        } else {
	            return new MinMax(left.min, left.max, 0, left.maxC);
	        }
	    } else if (left != null) {
	        if (left.count == 0) {
	            return new MinMax(left.min, left.max, 0, left.maxC);
	        } else {
	            return new MinMax(left.min, left.max, left.count + 1, 
	                Math.max(left.count + 1, left.maxC));
	        }
	    } else {
	        if (right.count == 0) {
	            return new MinMax(right.min, right.max, 0, right.maxC);
	        } else {
	            return new MinMax(right.min, right.max, right.count + 1, 
	                Math.max(right.maxC,right.count + 1));
	        }
	    }
	}
	private class MinMax {
	    int min;
	    int max;
	    int count;
	    int maxC;
	    MinMax(int min , int max, int count) {
	        this.min = min;
	        this.max = max;
	        this.count = count;
			maxC = 1;
	    }
	    MinMax(int min, int max, int count, int maxC) {
	        this.min = min;
	        this.max = max;
	        this.count = count;
	        this.maxC = maxC;
	    }
	 
	}

	public static void main(String[] args) {
		/* Let us construct the following Tree
			  50
			/	 \
			10	 60
		   / \	 / \
		  5  20 55 70
		        /  / \
		       45 65 80
		*/

		BinaryTree tree = new BinaryTree();
		tree.root = new Node(50);
		tree.root.left = new Node(10);
		tree.root.right = new Node(60);
		tree.root.left.left = new Node(5);
		tree.root.left.right = new Node(20);
		tree.root.right.left = new Node(55);
		tree.root.right.left.left = new Node(52);
		tree.root.right.right = new Node(70);
		tree.root.right.right.left = new Node(65);
		tree.root.right.right.right = new Node(80);

		/* The complete tree is not BST as 45 is in right subtree of 50.
		The following subtree is the largest BST
			60
			/ \
		55 70
		/	 / \
		45	 65 80
		*/
		System.out.println("Size of largest BST is " + tree.largestBST(root));
	}
}



