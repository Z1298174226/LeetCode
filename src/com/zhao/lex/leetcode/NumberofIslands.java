package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/12/24.
 */
public class NumberofIslands {
    private int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0 || grid == null) return 0;
        int m = grid.length; int n = grid[0].length; int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1')
                    count++;
            }
        }
        UnionFind unionFind = new UnionFind(count, m * n);
        boolean[] marked = new boolean[m * n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    help(i, j, unionFind, grid, marked);
                }
            }
        }
        return unionFind.count();
    }

    private void help(int row, int col, UnionFind unionFind, char[][] grid, boolean[] marked) {
        int m = grid.length; int n = grid[0].length;
        if(marked[row * n + col]) return;
        marked[row * n + col] = true;
        for(int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) continue;
            if(grid[newRow][newCol] != '1') continue;
            if(!unionFind.connected(row * n + col, newRow * n + newCol)) {
                unionFind.union(row * n + col, newRow * n + newCol);
            }
            help(newRow, newCol, unionFind, grid, marked);
        }
    }

    public class UnionFind {
        private int count;
        private int[] parents;
        public UnionFind(int count, int num) {
            this.parents = new int[num];
            this.count = count;
            for(int i = 0; i < num; i++)
                parents[i] = i;
        }

        public int find(int p) {
            if(p != parents[p]) {
                parents[p] = parents[parents[p]];
                p = parents[p];
            }
            return p;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int findP = find(p);
            int findQ = find(q);
            parents[findQ] = findP;
            count--;
        }

        public int count() {
            return count;
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        NumberofIslands numberofIslands = new NumberofIslands();
        System.out.println(numberofIslands.numIslands(grid));
    }
}
