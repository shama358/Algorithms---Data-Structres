/* Question
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where 
"adjacent" cells are those horizontally or vertically neighboring. The same 
letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        //early exit
        if (board == null || (board[0].length == 0 && board.length == 0) || 
                                                            word == null) {
            return false;
        }
        //consider every element in 'board' as the start till word not found
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                //maintains the visit records during each DFS
                boolean[][] visited = new boolean[board.length][board[0].length];
                //exit if word found
                //DFS graph traversal, where the nodes are elements in the board
                if(searchNeigh(word, board, visited, i , j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    //DFS graph traversal
    private boolean searchNeigh(String word, char[][] board, boolean[][] visited,
                                int row, int col, int idx) {
        //early exit if the cell was previously visited
        if (visited[row][col] || idx >= word.length()) {
            return false;
        }
        //set visited of the cell as true after visiting
        visited[row][col] = true;
        //early exit if the current cell element != current char in word
        if (word.charAt(idx) != board[row][col]) {
            //visited=false before returning, as the element is not considered
            visited[row][col] = false;
            return false;
        }
        //exit if end of word is reached.
        if (idx == word.length() - 1) {
            return true;
        }
        //searching the neighbours
        if (col != board[0].length - 1) {
            if(searchNeigh(word, board, visited, row, col + 1, idx + 1)) {
                return true;
            }
        }
        if (row != board.length - 1) {
            if (searchNeigh(word, board, visited, row + 1, col, idx + 1)) {
                return true;
            }
        }
        if (col != 0) {
            if (searchNeigh(word, board, visited, row, col - 1, idx + 1)) {
                return true;
            }
        }
        if (row != 0) {
            if (searchNeigh(word, board, visited, row - 1, col, idx + 1)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;        
    }
}