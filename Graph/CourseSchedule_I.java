/* Question
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to 
first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it 
possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have 
finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have 
finished course 0, and to take course 0 you should also have finished course 1. 
So it is impossible.
*/


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //early exit
        if (prerequisites == null) {
            return true;
        }
        //adjacency list
        LinkedList<Integer>[] Course_order = new LinkedList[numCourses];
        for (int i = 0 ; i < Course_order.length; ++i) {
            Course_order[i] = new LinkedList<Integer>();
        }
        populateCourseOrder(prerequisites, Course_order);
        //keeps track of the cources already completed
        HashSet<Integer> coursesTaken = new HashSet<Integer>();
        for (int i = 0 ; i < numCourses; ++i) {
            //keeps track of the cources taken in every DFS
            HashSet<Integer> finished = new HashSet<Integer>();
            //if the graph contains a cycle, then its impossible to finish.
            if (!coursesTaken.contains(i)) {
                if(FinishCourse(i, Course_order, coursesTaken, finished)) {
                    return false;
                }
            }
        }
        return true;
    }
    //populate adjacency list
    private void populateCourseOrder(int[][] prerequisites, 
                                     LinkedList<Integer>[] Course_order) {
        for(int i = 0; i < prerequisites.length; ++i) {
            Course_order[prerequisites[i][1]].add(prerequisites[i][0]);
        }
    }
    private boolean FinishCourse(int rootC, LinkedList<Integer>[] Course_order, 
                                 HashSet<Integer> coursesTaken, 
                                 HashSet<Integer> finished) {
        //add the current course in both the sets
        coursesTaken.add(rootC);
        finished.add(rootC);
        LinkedList<Integer> tmp = Course_order[rootC];
        for (int i : tmp) {
            if (finished.contains(i)) {
                return true;
            }
            if (!coursesTaken.contains(i) && FinishCourse(i, Course_order, 
                                                    coursesTaken, finished)) {
                return true;
            }
            //clean-up courses finished in this level.This is for detecting cycle
            finished.remove(i);
        }
        return false;
    }
}