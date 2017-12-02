/* Question
Equations are given in the format A / B = k, where A and B are variables 
represented as strings, and k is a real number (floating point number). Given 
some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, 
vector<pair<string, string>> queries , where equations.size() == values.size(), 
and the values are positive. This represents the equations. 
Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 

The input is always valid. You may assume that evaluating the queries will 
result in no division by zero and there is no contradiction.

*/


class Solution {
    public double[] calcEquation(String[][] equations, double[] values, 
                                 String[][] queries) {
        double[] res = new double[queries.length];
        //early exit
        if (equations == null || equations[0].length == 0 && 
                                        equations.length == 0) {
            return res;
        }
        /*build graph G, key -> 1st operand; value -> 2nd operand and its 
        corresponding value */
        HashMap<String, List<Edge>> G = new HashMap<String, List<Edge>>();
        for (int i = 0; i < equations.length; ++i) {
            insertEdge(equations[i][0], equations[i][1], values[i], G);
            insertEdge(equations[i][1], equations[i][0], 1.0 / values[i], G);
        }
        int idx = 0;
        //evaluating the equation and storing the result in res
        for (String[] q : queries) {
            retObj getRet = get (q[0], q[1], new HashSet<String>(),1.0, G);
            res[idx++] = getRet.value;
        }
        return res;
    }
    //class containing the end node and the value from values[]
    private class Edge {
        String end;
        double val;
        Edge(String e, double v) {
            end = e;
            val = v;
        }
    }
    //building the graph G
    private void insertEdge(String start, String end, double v, HashMap<String, 
                            List<Edge>> G) {
        List<Edge> e;
        if (G.containsKey(start)) {
            e = G.get(start);
        } else {
            e = new ArrayList<Edge>();
        }
        e.add(new Edge(end, v));
        G.put(start, e);
    }
    /*class having found(set to true if query end is reached) and the value 
    calculated */
    private class retObj {
        boolean found;
        double value;
        retObj(boolean f, double v) {
            found = f;
            value = v;
        }
    }
    //traverse path in graph according to the given query
    private retObj get(String start, String end, HashSet<String> visited, 
                       double val,
                       HashMap<String, List<Edge>> G) {
        if (!G.containsKey(start) || !G.containsKey(end)) {
            return new retObj(false, -1.0);
        }
        visited.add(start);
        if (start.equals(end)) {
            return new retObj(true, val);
        }
        for (Edge e : G.get(start)) {
            if (visited.contains(e.end)) {
                continue;
            }
            retObj ret = get(e.end, end, visited, val * e.val, G);
            if (ret.found) {
                return ret;
            }
        }
        return new retObj(false, -1.0);
    }
    
}