package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/24.
 */
public class ClimbingStairs {
//其实是个Fibonacci数列
    private static int count = 0;
    public static int climbStairs(int n) {
        int[] steps = new int[]{1, 2};
        dfs(n, steps);
        return count;
    }

    private static void dfs(int n, int[] steps) {
        if(n < 0) return;
        if(n == 0)
            count++;
        for(int step : steps) {
            dfs(n - step, steps);
        }
    }


    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }
}
