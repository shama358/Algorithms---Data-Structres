/* Question
Given a matrix of m x n elements (m rows, n columns), return all elements of the 
matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int r1 = 0, c1 = 0, r2 = matrix.length - 1, c2 = matrix[0].length - 1;
        //in one iteration 1 spiral motion is convered.
        while (r1 <= r2 && c1 <= c2) {
            spiralMat(r1,c1,r2,c2,res,matrix);
            ++r1;
            ++c1;
            --r2;
            --c2;                        
        }
        return res;
    }
    //adds teh elements of matrix in spiral order
    private void spiralMat(int r1, int c1, int r2, int c2, List<Integer> res, 
                           int[][] matrix) {
        for (int i = c1; i <= c2; ++i) {
            res.add(matrix[r1][i]);
        }
        for (int i = r1 + 1; i <= r2; ++i) {
            res.add(matrix[i][c2]);
        }
        for (int i = c2 - 1; i >= c1 && r1 < r2; --i) {
            res.add(matrix[r2][i]);
        }
        if (c1 != c2) {
            for (int i = r2 - 1; i >= r1 + 1; --i) {
                res.add(matrix[i][c1]);
            }
        }
        return;        
    }
}