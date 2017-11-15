/* Question

DFS Graph traversal

*/

class Graph {
    //no. of nodes
    int V;
    //adjacency list
    LinkedList<Integer>[] adj;
    //edgeTo[i] = the node from which node i was visited
    int[] edgeTo;
    //keeps track of visited nodes
    boolean[] visited;
    //constructor with initializations
    Graph(int v) {
        V = v;
        visited = new boolean[v];
        edgeTo = new int[v];
        adj = new LinkedList[v];
        //creating list in each array element
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<Integer>();
        }
    }
    //add egde to the adjacency list
    private void addEdge(int i, int j) {
        adj[i].add(j);
        adj[j].add(i);
    }
    //DFS
    public void DFS(int s) {
        //mark the current node as visited
        visited[s] = true;
        for (int i : adj[s]) {
            //if the node is not visited then visit the node
            if (!visited[i]) {
                DFS(i);
                edgeTo[i] = s;
            }
        }
    }
    //printing the edgeTo array.
    private void edgeToPrint() {
        for (int i = 0; i < edgeTo.length; ++i) {
            System.out.print(edgeTo[i]);
        }
    }
    public static void main(String args[])
    {
        Graph g = new Graph(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.DFS(0);
        g.edgeToPrint();
    }
}