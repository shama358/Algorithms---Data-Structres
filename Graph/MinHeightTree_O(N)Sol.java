/* Question
For a undirected graph with tree characteristics, we can choose any node as the 
root. The result graph is then a rooted tree. Among all possible rooted trees, 
those with minimum height are called minimum height trees (MHTs). Given such a 
graph, write a function to find all the MHTs and return a list of their root 
labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given 
the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are 
undirected, [0, 1] is the same as [1, 0] and thus will not appear together in 
edges.

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3
return [1]

Example 2:

Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5
return [3, 4]

Note:

(1) According to the definition of tree on Wikipedia: “a tree is an undirected 
graph in which any two vertices are connected by exactly one path. In other 
words, any connected graph without simple cycles is a tree.”

(2) The height of a rooted tree is the number of edges on the longest downward 
path between the root and a leaf.

*/

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new LinkedList<Integer>();
        //early exit
        if (n == 1) {
            res.add(0);
            return res;
        }
        //creating and populating adjacency list
        LinkedList<Integer>[] adj = new LinkedList[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new LinkedList<Integer>();
        }
        populateAdj(adj, edges);
        //queue to add the current leaf nodes
        Queue<Integer> q = new LinkedList<Integer>();
        //add leaf nodes of the given graph
        for (int i = 0; i < adj.length; ++i) {
            if(adj[i].size() == 1) {
                q.add(i);
            }
        }
        int numLeaves = n;
        /*remvoe the leaf nodes, remove the leaf node from adj of neighbouring 
        nodes and check if after removal the neighbouring nodes become the new 
        leaf node. If yea, then add to queue.*/
        while (numLeaves > 2) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int leaf = q.poll();
                --numLeaves;
                int neigh = adj[leaf].remove();
                /*cast required to specify to library function that you are 
                removing an object*/
                adj[neigh].remove((Integer)leaf);
                if(adj[neigh].size() == 1) {
                    q.add(neigh);
                }
                
            }
        }
        while (!q.isEmpty()) {
            res.add(q.remove());
        }
        return res;
    }
    private void populateAdj(LinkedList<Integer>[] adj, int[][] edges) {
        for (int[] edge : edges) {
            adj[edge[1]].add(edge[0]);
            adj[edge[0]].add(edge[1]);
        }
    }
}