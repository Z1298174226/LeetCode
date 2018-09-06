package com.zhao.lex.leetcode.second;

/**
 * Created by qtfs on 2018/8/28.
 */
public class LongestValidParentheses {
    public static int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];

        for(int i = 0; i < length; i++) {
            dp[i][i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(s.charAt(i) == s.charAt(j))
                    dp[j][i] = dp[j + 1][i -1] + 2;
                else
                    dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
            }
        }
        return dp[0][length - 1];
    }

    public static void main(String[] args) {
        String s = "abaa";
        System.out.println(LongestValidParentheses.longestPalindromeSubseq(s));
    }
}
