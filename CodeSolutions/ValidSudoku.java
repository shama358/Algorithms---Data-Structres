/* Question
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with
the character '.'.

A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the
filled cells need to be validated.
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board.length == 0 && board[0].length == 0) {
            return false;
        }
        //check if the row and the column have numbers 1-9 only once.
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (isValid(board, i, j, true)) { 
                    if (!isValid(board, i, j, false)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        //check if the sub squares have 1-9 only once
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[0].length; j += 3) {
                if (!isSubSquareValid(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int row, int col, boolean isRow) {
        ArrayList<Character> arr = new ArrayList<Character>();
        //check if the row has distinct numbers from 1-9
        if(isRow) {
            for (int i = col; i < board[0].length; ++i) {
                if (board[row][i] != '.') {
                    if (arr.contains(board[row][i])) {
                        return false;
                    } else {
                        arr.add(board[row][i]);
                    }
                }
            }
        } else {
            //check if the column has distinct numbers from 1-9
            for (int i = row; i < board.length; ++i) {
                if (board[i][col] != '.') {
                    if (arr.contains(board[i][col])) {
                        return false;
                    } else {
                        arr.add(board[i][col]);
                    }
                }
            }
        }
        return true;
    }
    private boolean isSubSquareValid(char[][] board, int row, int col) {
        ArrayList<Character> arr = new ArrayList<Character>();
        for (int i = row; i < row + 3; ++i) {
            for (int j = col; j < col + 3; ++j) {
                if (board[i][j] != '.') {
                    if (arr.contains(board[i][j])) {
                        return false;
                    } else {
                        arr.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}