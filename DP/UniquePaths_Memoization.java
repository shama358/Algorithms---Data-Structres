/* Question
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the
 diagram below).

The robot can only move either down or right at any point in time. The robot is 
trying to reach the bottom-right corner of the grid (marked 'Finish' in the 
diagram below).

How many possible unique paths are there?

Note: m and n will be at most 100.
*/

class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) {
            return 0;
        }
        /*key -> curernt cell, value -> no. of ways you can reach the end point 
        from this cell.*/
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        return paths(m*n, 1, n, 1, map);
        
    }
    private int paths(int target, int curr, int n, int currCol, 
                      HashMap<Integer, Integer> map) {
        if (curr == target) {
            return 1;
        }
        if (curr > target) {
            return 0;
        }
        //if no. paths from this cell is already computed, then return the value
        if (map.containsKey(curr)) {
            return map.get(curr);
        }
        int right = 0;
        //calc. the paths if you go down
        int down = paths(target, curr + n, n, currCol, map);
        //calc. the paths if you go right. the constraint is for the last col.
        if (currCol < n) {
            right = paths (target, curr + 1, n, currCol + 1, map);
        }
        if (!map.containsKey(curr)) {
            map.put(curr, down + right);
        }
        return down + right;
    }
}