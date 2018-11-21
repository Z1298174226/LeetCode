package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/11/11.
 */
public class BricksFallingWhenHit {
    private final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int row = grid.length;
        int col = grid[0].length;
        int number = hits.length;
        int[] result = new int[number];
        int[] parents = new int[row * col];
        int[] rank = new int[row * col];
        for(int i = 0; i < number; i++) {
            boolean[][] used = new boolean[row][col];
            grid[hits[i][0]][hits[i][1]] = 0;
            for(int j = 0; j < col; j++) {
                if(grid[0][j] == 1) {
                    grid[0][j] = 2;
                    dfs(used, grid, parents, rank, row, col, 0, j);
                }
            }
            int count = 0;
            for(int j = 0; j < row; j++) {
                for(int k = 0; k < col; k++) {
                    if(grid[j][k] == 1) {
                        count++;
                        grid[j][k] = 0;
                    }
                }
            }
            for(int j = 0; j < row; j++) {
                for(int k = 0; k < col; k++) {
                    if(grid[j][k] == 2)
                        grid[j][k] = 1;
                }
            }
            result[i] = count;
        }
        return result;
    }

    private void dfs(boolean[][] used, int[][] grid, int[] parents, int[] rank, int row, int col, int i, int j) {
        if(used[i][j]) return;
        used[i][j] = true;
        for(int[] direction : directions) {
            int newI = i + direction[0];
            if(newI == 0) continue;
            int newJ = j + direction[1];
            if(newI < 0 || newI >= row || newJ < 0 || newJ >= col) continue;
            if(grid[newI][newJ] == 1) {
                grid[newI][newJ] = 2;
                union(parents, rank, i * col + j, newI * col + newJ);
                dfs(used, grid, parents, rank, row, col, newI, newJ);
            }
        }
    }

    private int find(int[] parents, int num) {
        return num == parents[num] ? num : find(parents, parents[num]);
    }

    private boolean isConnected(int[] parents, int num1, int num2) {
        return find(parents, num1) == find(parents, num2);
    }

    private void union(int[] parents, int[] rank, int num1, int num2) {
        if(!isConnected(parents, num1, num2)) {
            int num1P = find(parents, num1);
            int num2P = find(parents, num2);
            if(rank[num1P] < rank[num2P])
                parents[num1P] = num2P;
            else
                parents[num2P] = num1P;
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1}, {1}, {1}, {1}, {1}};
        int[][] hits = new int[][]{{3, 0}, {4, 0}, {1, 0}, {2, 0}, {0, 0}};
        new BricksFallingWhenHit().hitBricks(grid, hits);
    }
}
