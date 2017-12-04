/* Question
Given an m x n matrix of non-negative integers representing the height of each 
unit cell in a continent, the "Pacific ocean" touches the left and top edges of 
the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to 
another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and 
Atlantic ocean.

Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.
Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with 
parentheses in above matrix).

*/

class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<int[]>();
        if (matrix == null || (matrix.length == 0 || matrix[0].length == 0)) {
            return res;
        }
        boolean[][] reachedPacific = 
            new boolean[matrix.length][matrix[0].length];
        boolean[][] reachedAtlantic = 
            new boolean[matrix.length][matrix[0].length];
        //checking all possible grids to reach from the first and last row
        for (int i = 0; i < reachedPacific.length; ++i) {
            reachableTo(matrix, reachedPacific, i, 0, i, 0);
            reachableTo(matrix, reachedAtlantic, i, 
                        reachedAtlantic[0].length - 1, i, 
                        reachedAtlantic[0].length - 1);
        }
        //checking all possible grids to reach from the first and last col
        for (int i = 0; i < reachedPacific[0].length; ++i) {
            reachableTo(matrix, reachedPacific, 0, i, 0, i);
            reachableTo(matrix, reachedAtlantic, 
                        reachedPacific.length - 1, i, 
                        reachedPacific.length - 1, i);
        }
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0;j < matrix[0].length; ++j) {
                if (reachedPacific[i][j] && reachedAtlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;                
    }
    /*checking all possible grids that can be reached, the condition being that 
    the next grid should be grater than or equal to current grid value */
    private void reachableTo(int[][] matrix, boolean[][] memoi, int r, int c, 
                             int prevR, int prevC) {
        if (memoi[r][c]) {
            return;
        }
        memoi[r][c] = true;
        if (r > 0 && matrix[r - 1][c] >= matrix[r][c] && (r - 1) != prevR) {
            reachableTo(matrix, memoi, r - 1, c, r, c);
        }
        if (r < matrix.length - 1 && matrix[r + 1][c] >= matrix[r][c] && 
            (r + 1) != prevR) {
            reachableTo(matrix, memoi, r + 1, c, r, c);
        }
        if (c > 0 && matrix[r][c - 1] >= matrix[r][c] && (c - 1) != prevC) {
            reachableTo(matrix, memoi, r, c - 1, r, c);
        }
        if (c < matrix[0].length - 1 && matrix[r][c + 1] >= matrix[r][c] && 
            (c + 1) != prevC) {
            reachableTo(matrix, memoi, r, c + 1, r, c);
        }
        return;        
    }

    
}