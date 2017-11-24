/* Question
Given a directed graph  your task is to complete the method isCycle  to detect 
if there is a cycle in the graph or not. You should not read any input from 
stdin/console.

There are multiple test cases. For each test case, this method will be called 
individually.

*/

class GfG
{
    public boolean hasCycle(int v,LinkedList<Integer>[] alist,boolean[] visited,
                            boolean[] explored) 
     {
       if (alist.length == 0) {
           return false;
       }

       for(int i = 0; i < alist.length; ++i) {
           //set to keep track of visited nodes
           HashSet<Integer> set = new HashSet<Integer>();
           if (!visited[i] && cycleFound(alist, visited, explored, i, set)) {
                return true;
            }
       }
       return false;
     }
     private boolean cycleFound(LinkedList<Integer>[] alist,boolean[] visited,
                    boolean[] explored, int root, HashSet<Integer> set) 
    {
        visited[root] = true;
        LinkedList<Integer> tmp = alist[root];
        for (int i : tmp) {
            if (set.contains(i)) {
                return true;
            }
            //add current node to set
            set.add(i);
            if (cycleFound(alist, visited, explored, i, set)) {
                return true;
            }
            //clean-up set after each level of recursion
            set.remove(i);
        }
        return false;
    }
}