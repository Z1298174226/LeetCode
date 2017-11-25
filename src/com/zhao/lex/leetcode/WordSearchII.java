package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2017/11/8.
 */
public class WordSearchII {

    private static final int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        boolean[][] marked = new boolean[board.length][board[0].length];
        for(String word : words) {
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(dfs(board, i, j, marked, word, 0)) {
                        if (!result.contains(word))
                            result.add(word);
                    }
                }
            }
        }
        return result;
    }
    private static boolean dfs(char[][] board, int row, int col, boolean[][] marked, String word, int start) {
        if(start > word.length() - 1) return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if(marked[row][col]) return false;
        if(board[row][col] == word.charAt(start)) {
            marked[row][col] = true;
            boolean temp = false;
            for(int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                temp = temp || dfs(board, newRow, newCol, marked, word, start + 1);
            }
            marked[row][col] = false;
            return temp;
        }
        else return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'C', 'A', 'A'},{'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String[] words = new String[]{"CAA", "AAB", "ABA", "CAD"};
        System.out.println(WordSearchII.findWords(board, words));
    }
}
