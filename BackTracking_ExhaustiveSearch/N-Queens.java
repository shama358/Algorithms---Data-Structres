/* Question
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such
that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' 
placement, where 'Q' and '.' both indicate a queen and an empty space 
respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/


public class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> res = new ArrayList<List<String>>();
        //initialising the board with '.'
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = '.';
            }
        }
        QueenRec(board, n, 0, res);
        return res;
    }
    private void QueenRec(char[][] board, int n, int row, 
	                      List<List<String>> res) {
        if (row == n) {
            res.add(new ArrayList<String>(ConvertBoardToList(board)));
            return;
        }
        for (int i = 0; i < n; ++i) {
            /* place the queen at the current position and check if the board is 
			valid */
            board[row][i] = 'Q';
            if (ValidBoard(board, row, i)) {
                QueenRec(board, n, row + 1, res);
            }
            board[row][i] = '.';
        }
        return;
    }
    //check if the board is valid
    private boolean ValidBoard(char[][] board, int row, int col) {
        int diaRowL = row, diaColL = col;
        int diaRowR = row, diaColR = col;
        //check row and col
        for (int i = 0; i < board.length; ++i) {
            if((i != col && board[row][i] == 'Q') || (i != row && 
			    board[i][col] == 'Q')) {
                return false;
            }
            //check left diagonals
            if(diaRowL != 0 && diaColL != 0 && 
			   board[--diaRowL][--diaColL] == 'Q') {
                return false;
            }
            //check right diagonals
            if(diaRowR != 0 && diaColR != (board.length - 1) && 
			   board[--diaRowR][++diaColR] == 'Q') {
                return false;
            }
        }  
        return true;        
    }
    //convert the board into list
    private List<String> ConvertBoardToList(char[][] board) {
        List<String> QueenPerm = new ArrayList<String>();
        for (int i = 0; i < board.length; ++i) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < board.length; ++j) {
                str = str.append(Character.toString(board[i][j]));
            }
            QueenPerm.add(new String(str));
        }
        return QueenPerm;
    }
}