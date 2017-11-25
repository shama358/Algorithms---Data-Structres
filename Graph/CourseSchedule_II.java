/* Question
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to 
first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the 
ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it 
is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have 
finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have 
finished both courses 1 and 2. Both courses 1 and 2 should be taken after you 
finished course 0. So one correct course order is [0,1,2,3]. Another correct 
ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency 
matrices. Read more about how a graph is represented.

You may assume that there are no duplicate edges in the input prerequisites.

*/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        //early exit in case there is no prerequisites
        if (prerequisites == null || prerequisites.length == 0 || 
            prerequisites[0].length == 0) {
            if (numCourses > 0) {
                for (int i = 0; i < numCourses; ++i) {
                    res[i] = i;
                }
                return res;
            }
        }
        //creating adjacency list
        LinkedList<Integer>[] adj = new LinkedList[numCourses];
        for (int i = 0; i < adj.length; ++i) {
            adj[i] = new LinkedList<Integer>();
        }
        populateAdj(adj, prerequisites);
        //keeps track of the courses completed.
        HashSet<Integer> finishedCourse = new HashSet<Integer>();
        //keeps track of the order of courses (reverse PostOrder)
        Stack courseOrder = new Stack();
        for (int i = 0; i < numCourses; ++i) {
            //keeps track of which courses are taken in the current DFS
            HashSet<Integer> explored = new HashSet<Integer>();
            //explore the course only if its not finished earlier
            if (!finishedCourse.contains(i)) {
                if (!canFinish(finishedCourse, adj, explored, i, courseOrder)) {
                    return new int[0];
                }
            }
        }
        //populating the resultant array from the stack
        for (int i = 0; i < numCourses & !courseOrder.isEmpty(); ++i) {
            res[i] = (int)courseOrder.pop();
        }
        return res;
    }
    //populating reverse adjacency list
    private void populateAdj(LinkedList<Integer>[] adj, int[][] prerequisites) {
        for (int i = 0; i < prerequisites.length; ++i) {
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }
    }
    //check if the all the courses can be finished, and determine the order
    private boolean canFinish(HashSet<Integer> finishedCourse, 
                              LinkedList<Integer>[] adj, 
                              HashSet<Integer> explored, int curr,
                              Stack courseOrder) {
        //add the current course to finished and explored sets
        finishedCourse.add(curr);
        explored.add (curr);
        LinkedList<Integer> tmp = adj[curr];
        for (int i : tmp) {
            /*if i had been explored in the current DFS, then a loop is exists, 
            and the courses are impossible to complete.*/
            if (explored.contains(i)) {
                return false;
            }
            //if the course was finished earlier, then continue
            if (finishedCourse.contains(i)) {
                continue;
            }
            if (!canFinish(finishedCourse, adj, explored, i, courseOrder)) {
                return false;
            }
            //clean-up to consider another DFS branch
            explored.remove(i);
        }
        //populate the stack (reverse postorder)
        courseOrder.push(curr);
        return true;
    }
}