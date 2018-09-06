package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/8/29.
 */
public class LargestSumofAverages {
    public double largestSumOfAverages(int[] A, int K) {
        if (A.length == 0) {
            return 0.0;
        }
        int[] sum = new int[A.length + 1];
        for (int i = 0; i < A.length; i ++) {
            sum[i+1] = sum[i] + A[i];
        }
        if (K == 0) {
            return sum[A.length-1] * 1.0 / A.length;
        }

        double[][] dp = new double[K+1][A.length];
        for (int i = 0; i < A.length; i ++) {
            dp[1][i] = sum[i+1] * 1.0 / (i + 1);
        }
        for (int k = 2; k <= K; k ++) {
            for (int i = 0; i < A.length; i ++) {
                for (int j = 0; j < i; j ++) {
                    double avg = (sum[i+1] - sum[j+1]) * 1.0 / (i - j);
                    dp[k][i] = Math.max(dp[k-1][j] + avg, dp[k][i]);
                }
            }
        }
        return dp[K][A.length-1];
    }
}
