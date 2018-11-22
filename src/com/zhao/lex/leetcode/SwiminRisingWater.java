package com.zhao.lex.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by qtfs on 2018/9/5.
 */
public class SwiminRisingWater {

//    private final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//    public int swimInWater(int[][] grid) {
//        int rows = grid.length;
//        int cols = grid[0].length;
//        int coordinats = rows * cols;
//        int[] parents = new int[coordinats];
//        for(int i = 0; i < coordinats; i++)
//            parents[i] = i;
//        int time = 0;
//        boolean[][] marked = new boolean[rows][cols];
//        while(!connected(0, coordinats - 1, parents)) {
////            for(int i = 0; i < coordinats; i++)
////                parents[i] = i;
//            for(int i = 0; i < rows; i++)
//                Arrays.fill(marked[i], false);
//            swim(marked, grid, time, parents, 0, 0, cols);
//            time++;
//        }
//        return time - 1;
//    }
//
//    public void swim(boolean[][] marked, int[][] grid, int time, int[] parents, int row, int col, int cols) {
//        if(marked[row][col]) return;
//        marked[row][col] = true;
//        for(int[] direction : directions) {
//            int newRow = row + direction[0];
//            int newCol = col + direction[1];
//            if(newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) continue;
//            if(grid[newRow][newCol] <= time && grid[row][col] <= time) {
//            //    marked[newRow][newCol] = true;
//                union(row * cols + col, newRow * cols + newCol, parents);
//                swim(marked, grid, time, parents, newRow, newCol, cols);
//             //   marked[newRow][newCol] = false;
//            }
//        }
//        marked[row][col] = false;
//    }
//
//    public int find(int coordinate, int[] parents) {
//        if(coordinate != parents[coordinate]) {
//            parents[coordinate] = parents[parents[coordinate]];
//            coordinate = parents[coordinate];
//        }
//        return coordinate;
//    }
//
//    public boolean connected(int coordinate1, int coordinate2, int[] parents) {
//        return find(coordinate1, parents) == find(coordinate2, parents);
//    }
//
//    public void union(int coordinate1, int coordinate2, int[] parents) {
//        if(!connected(coordinate1, coordinate2, parents))
//            parents[find(coordinate1, parents)] = find(coordinate2, parents);
//    }
//
    public static void main(String[] args) {
        int[][] grid = new int[][]{{6,23,16,13,7},{17,19,14,2,18},{0,22,17,21,9},{12,1,10,24,4},{5,20,3,16,15}};
        System.out.println(new SwiminRisingWater().swimInWater(grid));
    }

    public int swimInWater(int[][] grid) {
        int time = 0;
        int N = grid.length;
        Set<Integer> visited = new HashSet<>();
        while (!visited.contains(N * N - 1)) {
            visited.clear();
            dfs(grid, 0, 0, time, visited);
            time++;
        }
        return time - 1;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private void dfs(int[][] grid, int i, int j, int time, Set<Integer> visited) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] > time || visited.contains(i * grid[0].length + j))
            return;
        visited.add(i * grid.length + j);
        for (int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1], time, visited);
        }
    }

class UF {
    int[] id;

    public UF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        if (isConnected(p, q)) return;
        id[root(p)] = root(q);
    }
}
}
