/*Question
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
        if (n == 1) {
            res.add(0);
            return res;
        }
        //key : node, value : neighbouring nodes
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<Integer, 
                                                ArrayList<Integer>>();
        //populating the HashMap - creating adjacency list
        for (int i = 0; i < edges.length; ++i) {
            if(adj.containsKey(edges[i][0])) {
                ArrayList<Integer> tmp = adj.get(edges[i][0]);
                tmp.add(edges[i][1]);
                adj.put(edges[i][0], tmp);
            } else {
                ArrayList<Integer> edge = new ArrayList<Integer>();
                edge.add(edges[i][1]);
                adj.put(edges[i][0], edge);
            }
            if(adj.containsKey(edges[i][1])) {
                ArrayList<Integer> tmp = adj.get(edges[i][1]);
                tmp.add(edges[i][0]);
                adj.put(edges[i][1], tmp);
            } else {
                ArrayList<Integer> edge = new ArrayList<Integer>();
                edge.add(edges[i][0]);
                adj.put(edges[i][1], edge);
            }
        }
        int min = Integer.MAX_VALUE;
        //min height from each node
        for (int i = 0; i < n; ++i) {
            /*need to reset visited[] for dfs from every node as the task is 
            to find a node with min height compared to other nodes*/
            boolean[] visited = new boolean[n];
            //find the max height of every node & pick the min out of them
            int height = dfs(visited, adj, i, 0);
            if (height < min) {
                /*if min found then empty the result if not empty and add the 
                current node*/
                if (!res.isEmpty()) {
                    res = new LinkedList<Integer>();
                }
                res.add(i);
                min = height;
            } else if (height == min) {
                res.add(i);
            }
        }
        return res;
    }
    //find the maximum height of every node
    private int dfs(boolean[] visited, HashMap<Integer, ArrayList<Integer>> adj, 
                    int root, int height) {
        visited[root] = true;
        ArrayList<Integer> tmp = adj.get(root);
        int maxH = Integer.MIN_VALUE;
        for(int i : tmp) {
            if (!visited[i]) {
                maxH = Math.max(dfs(visited, adj, i, height + 1), maxH);
            }
        }
        return maxH == Integer.MIN_VALUE ? height : maxH;
    }
}