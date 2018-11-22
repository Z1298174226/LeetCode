package com.zhao.lex.goalsToOffer.backtracking;

/**
 * Created by qtfs on 2018/4/25.
 */
public class Solution {
    public final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++)
                if(dfs(matrix, i, j, rows, cols, str, 0))
                    return true;
        }
        return false;
    }

    private boolean dfs(char[] board, int row, int col, int rows, int cols, char[] word, int start) {
        if(start > word.length - 1) return true;
        if(row < 0 || row >= rows || col < 0 || col >= cols) return false;
        if(board[row * cols + col] == word[start]) {
            board[row * cols + col] ^= 256;
            boolean temp = false;
            for(int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                temp = temp || dfs(board, newRow, newCol,  rows, cols, word, start + 1);
            }
            board[row * cols + col] ^= 256;
            return temp;
        }else return false;
    }

     public static void main(String[] args) {
        Solution solution = new Solution();
        char[] matrix = new char[]{'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'c'};
        char[] str = new char[]{'a', 'b', 'c', 'c', 'e', 'd', 'a', 's'};
        System.out.println(solution.hasPath(matrix, 3, 4, str));
     }
}
