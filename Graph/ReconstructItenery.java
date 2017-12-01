/* Question
Given a list of airline tickets represented by pairs of departure and arrival 
airports [from, to], reconstruct the itinerary in order. All of the tickets 
belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that 
has the smallest lexical order when read as a single string. For example, the 
itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].

All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.

Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].

Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. 
But it is larger in lexical order.
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
        //build the graph
        buildGraph(adj, tickets);
        //stack for postorder traversal
        Stack sc = new Stack();
        travel_dfs("JFK", "JFK", adj, sc);
        while(!sc.isEmpty()) {
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
    //building graph and keeping track of #inbound for each vertex
    private void buildGraph(HashMap<String, PriorityQueue<String>> adj,
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
        }
    }
    
}