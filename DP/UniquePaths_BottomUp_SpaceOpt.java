/* Question
A robot is located at the top-left corner of a m x n grid.

The robot can only move either down or right at any point in time. The robot is 
trying to reach the bottom-right corner of the grid.

How many possible unique paths are there?
*/

class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) {
            return 0;
        }
        //bottom-up approach using only 1 row of the matrix
        int[] downArr = new int[n];
        for (int i = 0; i < n; ++i) {
            downArr[i] = 1;
        }
        for (int i = m - 2; i >= 0; --i) {
            int prev = 1;
            /*updating downArr with num of unique paths to reach the target 
            from matrix[i][j]*/
            for(int j = n - 2; j >= 0; --j) {
                int tmp = downArr[j] + prev;
                downArr[j] = tmp;
                prev = downArr[j];
            }
        }
        return downArr[0];        
    }
}