package com.zhao.lex.leetcode;

import java.util.Arrays;

/**
 * Created by qtfs on 2017/12/18.
 */
public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        if(cost.length == 1) return cost[0];
        int[] costs = new int[cost.length + 1];
        costs[0] = 0; int cnt = 1;
        for(int num : cost)
            costs[cnt++] = num;
        int n = costs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = costs[0];
        int[] stars = new int[]{1, 2};
        for(int i = 0; i < n; i++) {
            for(int star : stars) {
                if(i - star < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - star] + costs[i]);
            }
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public static void main(String[] args) {
        int[] stars = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(stars));
    }
}
