package leetcode;

/**
 * Created by qtfs on 2017/11/8.
 */
public class WordSearch {

    private static final int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, i, j, dirs, word, 0))
                    return true;
            }
        }
        return false;
    }
    private static boolean dfs(char[][] board, int row, int col, int[][] dirs,  String word, int start) {
        if(start > word.length() - 1) return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if(board[row][col] == word.charAt(start)) {
            board[row][col] ^= 256;   //我实在没想到可以这么操作，很强势
            boolean temp = false;
            for(int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                temp = temp || dfs(board, newRow, newCol, dirs,  word, start + 1);
            }
            board[row][col] ^= 256;
            return temp;
        }else return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'C', 'A', 'A'},{'A', 'A', 'A'}, {'B', 'C', 'D'}};//{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "AAB";
        System.out.println(WordSearch.exist(board, word));
    }

}
