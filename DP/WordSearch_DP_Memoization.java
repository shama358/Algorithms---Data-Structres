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
        //key -> curr(row, col, idx)    value-> false
        HashMap<RowColIdx, Boolean> map = new HashMap<RowColIdx, Boolean>();
        //consider every element in 'board' as the start till word not found
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                /*map contains only false records because you need to prune 
                only the part of tree which will not result in the word*/
                if(searchNeigh(word, board, visited, i , j, 0, map)) {
                    return true;
                }
            }
        }
        return false;
    }
    //DFS graph traversal
    private boolean searchNeigh(String word, char[][] board, boolean[][] visited,
                   int row, int col, int idx,  HashMap<RowColIdx, Boolean> map) {
        //early exit if the path was previously traversed with no result
        if (visited[row][col] || idx >= word.length() || map.containsKey
            (new RowColIdx(row, col, idx))) {
            return false;
        }
        visited[row][col] = true;
        //early exit if the current cell element != current char in word
        if (word.charAt(idx) != board[row][col]) {
            //adding the wrong-path in the map
            RowColIdx tmp = new RowColIdx(row, col, idx);
            map.put(tmp, false);
            //as the element is not considered
            visited[row][col] = false;
            return false;
        }
        //exit if end of word is reached.
        if (idx == word.length() - 1) {
            return true;
        }
        //searching the neighbours
        if (col != board[0].length - 1) {
            if(searchNeigh(word, board, visited, row, col + 1, idx + 1, map)) {
                return true;
            }
        }
        if (row != board.length - 1) {
            if (searchNeigh(word, board, visited, row + 1, col, idx + 1, map)) {
                return true;
            }
        }
        if (col != 0) {
            if (searchNeigh(word, board, visited, row, col - 1, idx + 1, map)) {
                return true;
            }
        }
        if (row != 0) {
            if (searchNeigh(word, board, visited, row - 1, col, idx + 1, map)) {
                return true;
            }
        }
        visited[row][col] = false;
        if (!map.containsKey(new RowColIdx(row, col, idx))) {
            map.put((new RowColIdx(row, col, idx)), false);
        }
        return false;        
    }
    //class containing the current row, col and idx
    private class RowColIdx {
        int row;
        int col;
        int idx;
        RowColIdx(int r, int c, int i) {
            row = r;
            col = c;
            idx = i;
        }
    }
}