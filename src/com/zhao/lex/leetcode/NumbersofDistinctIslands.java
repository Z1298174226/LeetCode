package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/12/26.
 */
public class NumbersofDistinctIslands {

    private int[][] directors = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0 || grid == null) return 0;
        int m = grid.length; int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1')
                    count++;
            }
        }
        UnionFind UF = new UnionFind(m * n, count);
        boolean[] marked = new boolean[m * n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1')
                    dfs(i, j, m, n, marked, grid, UF);
            }
        }
        return UF.count();
    }

    private void dfs(int row, int col, int m, int n, boolean[] marked, char[][] grid, UnionFind UF) {
        if(marked[row * n + col]) return;
        marked[row * n + col] = true;
        for(int[] director : directors) {
            int newRow = row + director[0];
            int newCol = col + director[1];
            if(newRow < 0 || newCol < 0 || newRow >= m || newCol >= n) continue;
            if(grid[newRow][newCol] != '1') continue;
            if(!UF.connected(row * n + col, newRow * n + newCol)) {
                UF.Union(row * n + col, newRow * n + newCol);
            }
            dfs(newRow, newCol, m, n, marked, grid, UF);
        }
    }

    public class UnionFind {
        int[] parents;
        int cnt;
        public UnionFind(int num, int cnt) {
            this.parents = new int[num];
            this.cnt = cnt;
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

        public void Union(int p, int q) {
            int findP = find(p);
            int findQ = find(q);
            parents[findP] = findQ;
            cnt--;
        }

        public int count() {
            return cnt;
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'0', '0', '1', '0', '1'}, {'0', '0', '1', '0', '0'},{'0', '0', '1', '1', '0'}, {'0', '0', '0', '1', '0'},{'1', '0', '0', '1', '0'}, {'0', '0', '1', '1', '0'}};
        NumbersofDistinctIslands numbersofDistinctIslands = new NumbersofDistinctIslands();
        System.out.println(numbersofDistinctIslands.numIslands(grid));
    }
}
