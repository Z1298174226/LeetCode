package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/1/8.
 */
public class PalindromePartitioningII {
    public static int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] cutNum = new int[n];
        for(int i = 0; i < s.length(); i++) {
            int min = i;
            for(int j = 0; j < i; j++) {
                dp[j][i] = (s.charAt(j) == s.charAt(i) && (i - j < 3 || dp[j + 1][i - 1]));
                if(dp[j][i]) {
                    min = (j == 0) ? 0 : Math.min(min, cutNum[j - 1] + 1);
                }
            }
            cutNum[i] = min;
        }
        return cutNum[n - 1];
    }

    public static void main(String[] args) {
        String s = "aa";
        System.out.println(minCut(s));
    }
}
