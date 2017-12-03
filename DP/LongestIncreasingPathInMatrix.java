/* Question
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down.
You may NOT move diagonally or move outside of the boundary (i.e. wrap-around 
is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/


class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        //initializing 2D matrix for memoization
        int[][] memoi = new int[matrix.length][matrix[0].length];
        int maxLen = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                maxLen = Math.max(maxLen, 
                                  getPath(memoi, i, j, 1, matrix, matrix[i][j]));
            }
        }
        return maxLen;
    }
    private int getPath(int[][] memoi, int r, int c, int[][] matrix,
                        int prev) {
        //if prior memoized, return the memoized value 
        if (memoi[r][c] != 0) {
            return memoi[r][c];
        }
        int mLen = 1;
        //longest path from curr cell = length of path via neighbouring cell + 1
        if (r < matrix.length - 1 && matrix[r + 1][c] > matrix[r][c]) {
            mLen = getPath(memoi, r + 1, c, matrix, matrix[r][c]) + 1;
        }
        if (r > 0 && matrix[r - 1][c] > matrix[r][c]) {
            mLen = Math.max(getPath(memoi, r - 1, c, matrix, matrix[r][c]) 
                            + 1, mLen);
        }
        if (c < matrix[0].length - 1 && matrix[r][c + 1] > matrix[r][c]) {
            mLen = Math.max(getPath(memoi, r , c + 1, matrix, matrix[r][c]) 
                            + 1, mLen);
        }
        if (c > 0 && matrix[r][c - 1] > matrix[r][c]) {
            mLen = Math.max(getPath(memoi, r , c - 1, matrix, matrix[r][c]) 
                            + 1, mLen);
        }
        //memoize the longest path from curr cell and return the length
        memoi[r][c] = mLen;
        return mLen;
    }
}