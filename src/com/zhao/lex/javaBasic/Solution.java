package com.zhao.lex.javaBasic;

/**
 * Created by qtfs on 2019/3/12.
 */
class Solution {
    static final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {1, -0}};
    static int result = 0;

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                dfs(matrix, i, j, 0);
            }
        }
        return result;
    }

    private void dfs(int[][] matrix, int row, int col, int count) {
        for(int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if(newRow < 0 || newCol < 0 || newRow >= matrix.length || newCol >= matrix[0].length) return;
            if(matrix[row][col] < matrix[newRow][newCol])
                result = Math.max(result, ++count);
            dfs(matrix, newRow, newCol, count + 1);
        }
    }
}
