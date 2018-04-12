package com.zhao.lex.leetcode.microsoft;

/**
 * Created by qtfs on 2018/4/4.
 */
public class WorkChoose {
    public static int step(int N, int[][] work) {
        int result = Integer.MIN_VALUE;
        int[] easy = new int[N];
        int[] hard = new int[N];
        int[] nothing = new int[N];
        easy[0] = work[0][0];
        nothing[0] = 0;
        hard[0] = 0;
        for(int i = 1; i < N; i++) {
            easy[i] = Math.max(easy[i - 1], hard[i - 1]) + work[i][0];
            nothing[i] = Math.max(nothing[i - 1], hard[i - 1]);
            hard[i] = nothing[i - 1] + work[i][1];
        }
        result = Math.max(easy[N - 1], hard[N - 1]);
        return result;
    }

    public static void main(String[] args) {
        int[][] work = new int[][]{{1, 2}, {4, 10}, {20, 21}, {1, 2}, {4, 10}, {20, 21}, {2, 23}, {40, 50}, {12, 35}, {2, 4}, {8, 9}, {2, 23}, {40, 50}, {12, 35}, {2, 4}, {8, 9}};
        System.out.println(step(16, work));
    }
}
