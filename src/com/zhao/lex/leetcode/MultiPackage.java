package com.zhao.lex.leetcode;

import com.zhao.lex.microsoft.MilkTea;

import java.util.Arrays;

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
        Arrays.fill(dp, 0);
        dp[0] = 0;
        for(int i = 1; i < N; i++) {
            for(int j = 0; j <= V; j++) {
                if(dp[j] >= 0)
                    dp[j] = M[i];
                else
                    dp[j] = -1;
            }
            for(int j = 0; j <= V - C[i]; j++) {
                if(dp[j] > 0)
                    dp[j + C[i]] = Math.max(dp[j + C[i]], dp[j] - 1);
            }
        }
        return dp[V];
    }

    public static void main(String[] args) {
        int[] C = new int[]{2};
        int[] M = new int[]{1};
        int[] W = new int[]{10};
        System.out.println(new MultiPackage().multiPackage(1, 2, C, M, W));
    }
}
