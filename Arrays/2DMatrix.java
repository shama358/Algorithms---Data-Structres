/*
Given a 2D matrix matrix, find the sum of the elements inside the rectangle 
defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12


Note:
You may assume that the matrix does not change.
There are many calls to sumRegion function.
You may assume that row1 ≤ row2 and col1 ≤ col2.

*/


/*

Construct a 2D array sumRegion[row+1][col+1]

(notice: we add additional blank row sumRegion[0][col+1]={0} and blank column 
sumRegion[row+1][0]={0} to remove the edge case checking), so, we can have the 
following definition

sumRegion[i+1][j+1] represents the sum of area from matrix[0][0] to matrix[i][j]

To calculate sums, the ideas as below

+-----+-+-------+     +--------+-----+     +-----+---------+     +-----+--------+
|     | |       |     |        |     |     |     |         |     |     |        |
|     | |       |     |        |     |     |     |         |     |     |        |
+-----+-+       |     +--------+     |     |     |         |     +-----+        |
|     | |       |  =  |              |  +  |     |         |  -  |              |
+-----+-+       |     |              |     +-----+         |     |              |
|               |     |              |     |               |     |              |
|               |     |              |     |               |     |              |
+---------------+     +--------------+     +---------------+     +--------------+

   sumRegion[i][j]      =    sumRegion[i-1][j] + sumRegion[i][j-1] - 
					sumRegion[i-1][j-1]   +  matrix[i-1][j-1]
So, we use the same idea to find the specific area's sum.

+---------------+   +--------------+   +---------------+   +--------------+   +--------------+
|               |   |         |    |   |   |           |   |         |    |   |   |          |
|   (r1,c1)     |   |         |    |   |   |           |   |         |    |   |   |          |
|   +------+    |   |         |    |   |   |           |   +---------+    |   +---+          |
|   |      |    | = |         |    | - |   |           | - |      (r1,c2) | + |   (r1,c1)    |
|   |      |    |   |         |    |   |   |           |   |              |   |              |
|   +------+    |   +---------+    |   +---+           |   |              |   |              |
|        (r2,c2)|   |       (r2,c2)|   |   (r2,c1)     |   |              |   |              |
+---------------+   +--------------+   +---------------+   +--------------+   +--------------+


*/


public class NumMatrix {
    private int[][] sumRegion;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        sumRegion = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < sumRegion.length; ++i) {
            for (int j = 1; j < sumRegion[0].length; ++j) {
                sumRegion[i][j] = matrix[i - 1][j - 1] + sumRegion[i][j - 1] + 
				sumRegion[i - 1][j] - sumRegion[i - 1][j - 1];
                /* you subtract the last region as that region is already added 
				twice by the frist 2 sumRegions */
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRegion[row2 + 1][col2 + 1] - sumRegion[row2 + 1][col1] - 
		sumRegion[row1][col2 + 1] + sumRegion[row1][col1];
    }
}


/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */


/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */