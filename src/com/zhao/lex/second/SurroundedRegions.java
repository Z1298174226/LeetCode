package com.zhao.lex.second;

/**
 * Created by qtfs on 2018/9/8.
 */
public class SurroundedRegions {
    public final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        if (board.length < 2 || board[0].length < 2)
            return;
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] marked = new boolean[rows][cols];
        for(int i = 0; i < cols; i++) {
            if(board[0][i] == 'O')
                board[0][i] = 'Y';
            if(board[rows - 1][i] == 'O')
                board[rows - 1][i] = 'Y';
        }
        for(int i = 0; i < rows; i++) {
            if(board[i][0] == 'O')
                board[i][0] = 'Y';
            if(board[i][cols - 1] == 'O')
                board[i][cols - 1] = 'Y';
        }
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'Y')
                    help(board, i, j, marked);
            }
        }
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == 'Y')
                    board[i][j] = 'O';
            }
        }
    }

    private void help(char[][] board, int row, int col, boolean[][] marked) {
        if(marked[row][col]) return;
        marked[row][col] = true;
        for(int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if(newRow < 0 || newRow > board.length - 1 || newCol < 0 || newCol > board[0].length - 1) continue;
            if(board[newRow][newCol] == 'O') {
                board[newRow][newCol] = 'Y';
                help(board, newRow, newCol, marked);
            }
        }
    }
}
