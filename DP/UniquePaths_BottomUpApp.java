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
        //Bottom-up approach.
        int[][] paths = new int[m][n];
        /* since from the last column and the last row, the end point can be 
        reached in only 1 way, they are set to 1.*/
        for (int i = 0; i < n; ++i) {
            paths[m - 1][i] = 1;
        }
        for (int i = 0; i < m; ++i) {
            paths[i][n - 1] = 1;
        }
        /*we start from the last cell in the grid, process each row starting 
        from the last column till we reach the first cell.*/
        for (int i = m - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                paths[i][j] = paths[i + 1][j] + paths[i][j + 1];
            }
        }
        return paths[0][0];
    }
}