/* Question
Given a 2D binary matrix filled with 0's and 1's, find the largest square 
containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int max = 0;
        //check for max square starting from each element
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (matrix[i][j] == '1') {
                    max = Math.max(sq(matrix, i, j), max);
                }
            }
        }
        return max;
    }
    //increase the size of square by 1 if the current square is flled with 1s.
    private int sq(char[][] matrix, int r, int c) {
        int idx = 0;
        int count = 0;
        for (int i = r; i <= r + idx && i < matrix.length; ++i) {
            //reset set to true when the size of the square is increased.
            boolean reset = false;
            for (int j = c; j <= c + idx && j < matrix[0].length; ++j) {
                if (matrix[i][j] != '1') {
                    if (idx == 0) {
                        return 1;
                    }
                    return idx * idx;
                }
                ++count;
                //iterate the extra column when the square size is increased.
                if (reset) {
                    if (i == r + idx - 1 && j == c + idx) {
                        break;
                    }
                    ++i;
                    if (j != 0) {
                        --j;
                    }
                }
                /*increase size of square when right bottom-most element of 
                current square is reached.*/
                if (i == r + idx && j == c + idx) {
                    //return if the increase goes out of bounds
                    if (c + idx + 1 >= matrix[0].length || 
                        r +idx + 1 >= matrix.length) {
                        if (idx == 0) {
                            return 1;
                        }
                        return (idx + 1) * (idx + 1);
                    }
                    ++idx;
                    i = r;
                    reset = true;
                }
            }
            /*the extra row got by increasing the size of the square is 
            iterated by the outer for loop.*/
        }
        return idx * idx;
    }
}