/* Question
Given a undirected graph  your task is to complete the method isCycle  to detect 
if there is a cycle in the undirected graph or not. You should not read any 
input from stdin/console.

There are multiple test cases. For each test case, this method will be called 
individually.
*/


/* Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


class GfG
{
    Boolean isCyclic(int V,LinkedList<Integer>[] alist)
    {
       if (alist.length == 0) {
           return false;
       }
       //visited[] keeps track of visited nodes
       boolean[] visited = new boolean[V];
       for(int i = 0; i < V; ++i) {
           //DFS starting from nodes which are not visited
            if (!visited[i] && cycleFound(alist, visited, i, i)) {
                return true;
            }
       }
       return false;
    }
    //DFS traversal
    private boolean cycleFound(LinkedList<Integer>[] alist, boolean[] visited,
                int root, int parent) {
        visited[root] = true;
        LinkedList<Integer> tmp = alist[root];
        for(int i : tmp) {
            //this handels self loops -> return true on self loops
            //if node i is incident node but it is not the incident node
            if (i == parent && i != root) {
                continue;
            }
            if (visited[i]) {
                return true;
            }
            if(cycleFound(alist, visited, i, root)) {
                return true;
            }
        }
        return false;
    }
}