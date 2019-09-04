package com.zhao.lex.leetcode;


/**
 * Created by qtfs on 2018/12/8.
 */

/*
有N种物品和一个容量为V 的背包。第i种物品最多有Mi件可用，每件耗费
的空间是Ci，价值是Wi。求解将哪些物品装入背包可使这些物品的耗费的空间
总和不超过背包容量，且价值总和最大。
 */

public class MultiPackage {

    public int multiPackage(int N, int V, int[] C, int[] M, int[] W) {
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= M[i]; j++) {
                for (int k = V; k >= C[i]; k--) {
                    dp[k] = Math.max(dp[k], dp[k - C[i]] + W[i]);
                }
            }
        }
        return dp[V];
    }

    public static void main(String[] args) {
        int[] C = new int[]{2, 20};
        int[] M = new int[]{8, 8};
        int[] W = new int[]{5, 5};
        System.out.println(new MultiPackage().multiPackage(2, 100, C, M, W));
    }
}
