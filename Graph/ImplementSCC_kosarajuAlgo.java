/* Question

Given a set of ticekts, build an itinerary list such that all the tickets are used.

*/

/* this is a directed graph problem which requires every edge to be visited 
exactly once, which is the euler path.

Euler path requires :
1. every edge is strongly connected (Kosaraju's algorithm)
2. in-degree == out-degree for every node except 2, in which 1 node should have 
out-degree = in-degree + 1 and the other as in-degree = out-degree + 1

This solution has the implementation of SCC (Strongly connected component)
*/


class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<String>();
        if (tickets == null || tickets.length == 0 && tickets[0].length == 0) {
            return res;
        }
        //key -> starting point; value -> priorityQueue of destinations
        HashMap<String, PriorityQueue<String>> adj = new HashMap<String, 
        PriorityQueue<String>>();
        //keeps track of in-degree of each node
        HashMap<String, Integer> in_degree = new HashMap<String, Integer>();
        /*Reverse graph ->-> key -> starting point; value -> priorityQueue of 
        destinations*/
        HashMap<String, PriorityQueue<String>> transpose = new HashMap<String, 
        PriorityQueue<String>>();
        //build the graph
        buildGraph(adj, in_degree, tickets);
        //build transpose graph
        buildTranspose(transpose, adj);
        //stack for SCC and for postorder traversal
        Stack sc = new Stack();
        if(!SC(adj, transpose, tickets)) {
            return res;
        }
        travel_dfs("JFK", "JFK", adj, sc);
        while (!sc.isEmpty()) {
            res.add((String)sc.pop());
        }
        return res;
    }
    //post order DFS traversal
    private void travel_dfs(String from, String to, HashMap<String, 
                            PriorityQueue<String>> adj, Stack sc) {
         //instead of keeping track of visited edges, remove the edge from adj
        PriorityQueue<String> t = adj.get(to);
        while(t != null && t.size() > 0) {
            String s = t.poll();
            travel_dfs(from, s, adj, sc);
        }
        sc.push(to);
    }
    
    //building transpose graph
    private void buildTranspose(HashMap<String, PriorityQueue<String>> transpose, 
                                HashMap<String, PriorityQueue<String>> adj) {
        for (Map.Entry<String, PriorityQueue<String>> e : adj.entrySet()) {
            for (String s : e.getValue()) {
                PriorityQueue<String> t;
                if (transpose.containsKey(s)) {
                    t = transpose.get(s);
                    t.add(e.getKey());
                } else {
                    t = new PriorityQueue<String>();
                    t.add(e.getKey());
                }
                transpose.put(s, t);
            }
        }
    }
    
    //checking if the vertices are strongly connected
    private boolean SC(HashMap<String, PriorityQueue<String>> adj, HashMap<String, 
                       PriorityQueue<String>> transpose, String[][] tickets) {
        Stack sc = new Stack();
        HashSet<String> visited = new HashSet<String>();
        for (Map.Entry<String, PriorityQueue<String>> e : adj.entrySet()) {
            if (!visited.contains(e.getKey())) {
                fillStack(e.getKey(), sc, visited, adj);
            }
        }
        visited = new HashSet<String>();
        while (!sc.isEmpty()) {
            String tmp = (String)sc.pop();
            if (!visited.contains(tmp)) {
                dfs(tmp, visited, transpose);
            }
        }
        for (String[] From_to : tickets) {
            if (!visited.contains(From_to[0]) || !visited.contains(From_to[1])) {
                return false;
            }
        }
		//also check the 2nd condition.This problem does not require to check that.
        return true;
    }
    //dfs traversal to puch elements in stack for SCC
    private void fillStack (String root, Stack sc, HashSet<String> visited,
                            HashMap<String, PriorityQueue<String>> adj) {
        visited.add(root);
        PriorityQueue<String> iter = adj.get(root);
        if (iter != null) {
            for (String s : iter) {
                if (!visited.contains(s)) {
                    fillStack(s, sc, visited, adj);
                }
            }
        }
        sc.push(root);
    }
    //dfs of transpose graph
    private void dfs(String root, HashSet<String> visited, 
                     HashMap<String, PriorityQueue<String>> transpose) {
        visited.add(root);
        PriorityQueue<String> iter = transpose.get(root);
        if (iter != null) {
            for (String s : iter) {
                if (!visited.contains(s)) {
                    dfs(s, visited, transpose);
                }
            }
        }
    }
    
    //building graph and keeping track of #inbound for each vertex
    private void buildGraph(HashMap<String, PriorityQueue<String>> adj,
                            HashMap<String, Integer> in_degree, 
                            String[][] tickets) {
        for (String[] From_to : tickets) {
            PriorityQueue<String> neigh;
            if (adj.containsKey(From_to[0])) {
                neigh = adj.get(From_to[0]);
                neigh.add(From_to[1]);
            } else {
                neigh = new PriorityQueue<String>();
                neigh.add(From_to[1]);
            }
            adj.put(From_to[0], neigh);
            if (in_degree.containsKey(From_to[1])) {
                in_degree.put(From_to[1],(in_degree.get(From_to[1]) + 1));
            } else {
                in_degree.put(From_to[1], 1);
            }
        }
    }
}