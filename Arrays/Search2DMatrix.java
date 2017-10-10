/* Question
Write an efficient algorithm that searches for a value in an m x n matrix. 
This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous 
row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        //Binary Search to find the right row.
        int lo = 0, hi = matrix.length - 1;
        int prev = -1;
        while (lo <= hi) {
            int mid = lo + (hi -lo) / 2;
            int n = matrix[mid][0];
            if (n > target) {
                hi = mid - 1;
            } else if (n < target) {
                lo = mid + 1;
                prev = lo;
            } else {
                return true;
            }
        }
        //early exit if prev < 0
        if (prev < 0) {
            return false;
        }
        int row;
        //prev correction
        if(prev < matrix.length && matrix[prev - 1][matrix[0].length - 1] 
           < target) {
            row = prev;
        } else {
            row = --prev;
        }
        //binary search for finding the element in "row"
        lo = 0;
        hi = matrix[0].length - 1;
        while(lo <= hi) {
            int mid = lo + (hi -lo) / 2;
            int n = matrix[row][mid];
            if (n > target) {
                hi = mid - 1;
            } else if (n < target) {
                lo = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}