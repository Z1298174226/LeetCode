package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/12/24.
 */
public class NumberofIslands {
//    private int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
//
//    public int numIslands(char[][] grid) {
//        if(grid.length == 0 || grid[0].length == 0 || grid == null) return 0;
//        int m = grid.length; int n = grid[0].length; int count = 0;
//        for(int i = 0; i < m; i++) {
//            for(int j = 0; j < n; j++) {
//                if(grid[i][j] == '1')
//                    count++;
//            }
//        }
//        UnionFind unionFind = new UnionFind(count, m * n);
//        boolean[] marked = new boolean[m * n];
//        for(int i = 0; i < m; i++) {
//            for(int j = 0; j < n; j++) {
//                if(grid[i][j] == '1') {
//                    help(i, j, unionFind, grid, marked);
//                }
//            }
//        }
//        return unionFind.count();
//    }
//
//    private void help(int row, int col, UnionFind unionFind, char[][] grid, boolean[] marked) {
//        int m = grid.length; int n = grid[0].length;
//        if(marked[row * n + col]) return;
//        marked[row * n + col] = true;
//        for(int[] direction : directions) {
//            int newRow = row + direction[0];
//            int newCol = col + direction[1];
//            if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) continue;
//            if(grid[newRow][newCol] != '1') continue;
//            if(!unionFind.connected(row * n + col, newRow * n + newCol)) {
//                unionFind.union(row * n + col, newRow * n + newCol);
//            }
//            help(newRow, newCol, unionFind, grid, marked);
//        }
//    }
//
//    public class UnionFind {
//        private int count;
//        private int[] parents;
//        public UnionFind(int count, int num) {
//            this.parents = new int[num];
//            this.count = count;
//            for(int i = 0; i < num; i++)
//                parents[i] = i;
//        }
//
//        public int find(int p) {
//            if(p != parents[p]) {
//                parents[p] = parents[parents[p]];
//                p = parents[p];
//            }
//            return p;
//        }
//
//        public boolean connected(int p, int q) {
//            return find(p) == find(q);
//        }
//
//        public void union(int p, int q) {
//            int findP = find(p);
//            int findQ = find(q);
//            parents[findQ] = findP;
//            count--;
//        }
//
//        public int count() {
//            return count;
//        }
//    }

    private int count = 0;
    private final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[] parents = new int[row * col];
        int[] rank = new int[row * col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1')
                    count++;
                parents[i * col + j] = i * col + j;
                rank[i * col + j]++;
            }
        }
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1')
                    dfs(row, col, i, j, parents, rank, grid);
            }
        }
        return count;
    }

    private void dfs(int row, int col, int i, int j, int[] parents, int[] rank, char[][] grid) {
        grid[i][j] ^= 256;
        for(int[] direction : directions) {
            int newi = i + direction[0];
            int newj = j + direction[1];
            if(newi < 0 || newi >= row || newj < 0 || newj >= col) continue;
            if(grid[newi][newj] == '1') {
                union(i * col + j, newi * col + newj, parents, rank);
                dfs(row, col, newi, newj, parents, rank, grid);
            }
        }
    }

    private int find(int[] parents, int value) {
        if(value != parents[value]) {
            parents[value] = parents[parents[value]];
            value = parents[value];
        }
        return value;
    }

    private boolean isConnected(int s, int t, int[] parents) {
        int parentS = find(parents, s);
        int parentT = find(parents, t);
        return parentS == parentT;
    }

    private void union(int s, int t, int[] parents, int[] rank) {
        if(!isConnected(s, t, parents)) {
            if(rank[find(parents, s)] >= rank[find(parents, t)]) {
                parents[find(parents, t)] = find(parents, s);
                rank[find(parents, s)]++;
            }
            else {
                parents[find(parents, s)] = find(parents, t);
                rank[find(parents, t)]++;
            }
            count--;
        }
    }

    public static void main(String[] args) {
//        char[][] grid = new char[][]{{'0', '0', '1', '0', '1'}, {'0', '0', '1', '0', '0'},{'0', '0', '1', '1', '0'}, {'0', '0', '0', '1', '0'},{'1', '0', '0', '1', '0'}, {'0', '0', '1', '1', '0'}};
        char[][] grid = new char[][]{{'1','0','1','1','1'},{'1','0','1','0','1'},{'1','1','1','0','1'}};
        NumberofIslands numberofIslands = new NumberofIslands();
        System.out.println(numberofIslands.numIslands(grid));
    }
}
