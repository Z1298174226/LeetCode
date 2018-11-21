package com.zhao.lex.leetcode;

import java.util.Arrays;

/**
 * Created by qtfs on 2018/11/21.
 */
public class CuttheRope {
    public int cutTheRope(int length, int num) {
        if(length == 0 || num == 0) return 0;
        int[][] dp = new int[num + 1][length + 1];
        for(int i = 0; i <= length; i++)
            dp[1][i] = i;
        for(int k = 2; k <= num; k++) {
            for(int i = 2; i <= length; i++) {
                for(int j = 1; j < i; j++) {
                    if((i - j) / (k - 1) < 1) break;
                    dp[k][i] = Math.max(dp[k][i], dp[k - 1][i - j] * j);
                }
            }
        }
        return dp[num][length];
    }

    public static void main(String[] args) {
        System.out.println(new CuttheRope().cutTheRope(180, 170));
    }
}
