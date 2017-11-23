/* Questoin
In this problem, a tree is an undirected graph that is connected and has no 
cycles.

The given input is a graph that started as a tree with N nodes (with distinct 
values 1, 2, ..., N), with one additional edge added. The added edge has two 
different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a 
pair [u, v] with u < v, that represents an undirected edge connecting nodes u 
and v.

Return an edge that can be removed so that the resulting graph is a tree of N 
nodes. If there are multiple answers, return the answer that occurs last in the 
given 2D-array. The answer edge [u, v] should be in the same format, with u < v.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3
Example 2:
Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
Explanation: The given undirected graph will be like this:
5 - 1 - 2
    |   |
    4 - 3
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is 
the size of the input array.

*/

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        //erly exit 
        if (edges == null || edges.length == 0 && edges[0].length == 0) 
        {
            return new int[]{0, 0};
        }
        //adjacency list
        HashMap<Integer, List<Integer>> adj = new HashMap<Integer, 
                                                List<Integer>>();
        populateAdj(edges, adj);
        //set containing edges of the cycle
        HashSet<List<Integer>> loop_edge = new HashSet<List<Integer>>();
        //iterating throught the nodes to find the cycle
        for(int i : adj.keySet()) {
            loop_edge = new HashSet<List<Integer>>();
            boolean[] visited = new boolean[edges.length + 1];
            loopEdge found = loopFound(i, loop_edge, visited, adj, i);
            if (found.found) {
                break;
            }
        }
        int[] res = new int[2];
        /*check if edges,from the end of the given 2D array, is 
        present in the set.
        The edge can either be a-b or b-a as it is an undirected 
        graph. Check for both values.*/
        for (int i = edges.length - 1; i >= 0; --i) {
            List<Integer> combo1 = new ArrayList<Integer>();
            combo1.add(edges[i][0]);
            combo1.add(edges[i][1]);
            if (loop_edge.contains(combo1)) {
                res[0] = edges[i][0];
                res[1] = edges[i][1];
                break;
            }
            List<Integer> combo2 = new ArrayList<Integer>();
            combo2.add(edges[i][1]);
            combo2.add(edges[i][0]);
            if (loop_edge.contains(combo2)) {
                res[0] = edges[i][0];
                res[1] = edges[i][1];
                break;
            }        
        }
        return res;
    }
    //populate the adjacency list.
    private void populateAdj(int[][] edges, HashMap<Integer, 
                             List<Integer>> adj) {
        for (int i = 0; i < edges.length; ++i) {
            for (int j = 0; j < 2; ++j) {
                List<Integer> tmp;
                if(adj.containsKey(edges[i][j])) {
                    tmp = adj.get(edges[i][j]);
                    if(j == 1) {
                        tmp.add(edges[i][0]);
                    } else {
                        tmp.add(edges[i][1]);
                    }
                } else {
                    tmp = new ArrayList<Integer>();
                    if(j == 1) {
                        tmp.add(edges[i][0]);
                    } else {
                        tmp.add(edges[i][1]);
                    }
                }
                adj.put(edges[i][j], tmp);
            }
        }
        return;
    }
    //finding if a cycle is present by doing reverses postorder
    private loopEdge loopFound(int root, HashSet<List<Integer>> loop_edge, 
                               boolean[] visited, HashMap<Integer, 
                               List<Integer>> adj, int parent) {
        visited[root] = true;
        List<Integer> neigh = adj.get(root);
        loopEdge nextNode = new loopEdge(false, root, false, root);
        for (int i : neigh) {
            //if the node is parent, then continue
            if (i == parent) {
                continue;
            }
            /*cycle is found if the node was previously visited and is 
            not the parent. Add the edge to the loop_Edge*/
            if (visited[i]) {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(i);
                tmp.add(root);
                loop_edge.add(tmp);
                return new loopEdge(true, root, false, i);
            }
            //rec call
            nextNode = loopFound(i, loop_edge, visited, adj, root);
            //if loop is completed, early exit
            if(nextNode.loopCompleted) {
                return nextNode;
            }
            //add edges of the loop to loop_edge
            if (nextNode.found) {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(nextNode.prevNode);
                tmp.add(root);
                loop_edge.add(tmp);
                /*when the begining of the loop is reached return saying 
                loop completed for early termination*/
                if (root == nextNode.loop_start) {
                    return new loopEdge(true, root, true, root);
                } else {
                    return new loopEdge(true, root, false, nextNode.loop_start);
                }
                
            }
            
        }
        return nextNode;
    }
    /*private class with variable found(true if cycle found), prevNode,
    loopCompleted(true if last node of the loop is reached), 
    loop_start(point at which the loop was found) */
    private class loopEdge {
        boolean found;
        int prevNode;
        boolean loopCompleted;
        int loop_start;
        loopEdge(boolean fnd, int p, boolean comp, int s) {
            found = fnd;
            prevNode = p;
            loopCompleted = comp;
            loop_start = s;
        }
    }
}