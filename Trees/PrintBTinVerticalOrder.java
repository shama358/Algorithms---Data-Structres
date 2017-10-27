/* Question
Given a binary tree, your task is to complete the function verticalOrder which 
takes one argument the root of the binary tree and prints the node of the binary 
tree in vertical order .

          1
       /     \
     2       3
   /        /
4       5

The nodes of the above tree printed in vertical order will be
4
2
1 5
3
Your output should be 4 $2 $1 5 $3 $

Note: Each vertical line will be separated by a "$" without quotes.
*/


// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */
/* Should print vertical order such that each vertical line
    is separated by $ */
class GfG
{
    void verticalOrder(Node node) 
    {
        // Early exit if tree is empty
        if (node == null) {
            return;
        }
        //Key -> displacement from root; 
        //value -> nodes having the same displacement(nodes in the same column)
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, 
                                                        ArrayList<Integer>>();
        //group nodes with same column, i.e, group nodes in order of columns
        columnOrder(node, 0, map);
        /*Since the output is required to be ordered from left-most col to right 
        most, find the maximum displacement*/
        int max = 0;
        for (int i : map.keySet()) {
            if (i > max) {
                max =i;
            }
        }
        //print from highest displacement to the lowest.
        while(!map.isEmpty()) {
            ArrayList<Integer> tmp = map.get(max);
            map.remove(max);
            for (int i : tmp) {
                System.out.print(i+" ");
            }
            System.out.print("$");
            --max;
        }
    }
    //this function groups nodes in order of columns
    private void columnOrder(Node node, int dis, HashMap<Integer,  
                                ArrayList<Integer>> map) {
        if (node == null) {
            return;
        }
        //add the current node
        addNode(map, node, dis);
        //left : displacement + 1, right : displacement - 1
        columnOrder(node.left, dis + 1, map);
        columnOrder(node.right, dis - 1, map);
    }
    //add nodes in their respective column
    private void addNode(HashMap<Integer, ArrayList<Integer>> map, Node node, 
                                                            int k) {
        if  (!map.containsKey(k)) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.add(node.data);
            map.put(k, tmp);
        } else {
            ArrayList<Integer> tmp = map.get(k);
            tmp.add(node.data);
            map.put(k, tmp);
        }
    }
}