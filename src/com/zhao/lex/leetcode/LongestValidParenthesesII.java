package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/3.
 */
public class LongestValidParenthesesII {
    public static int longestValidParentheses(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        return 2 * longestHelp(s, dp, s.length(), s.length());

    }

    private static int longestHelp(String s, int[][] dp, int len_1, int len_2) {
        if(dp[len_1][len_2] != 0) return dp[len_1][len_2];
        if(len_1 == 0 || len_2 == 0) return 0;
        if(s.charAt(len_1 - 1) == '(' && s.charAt(len_2 - 1) == ')' && len_1 < len_2) {
            int temp = longestHelp(s, dp, len_1 - 1, len_2 - 1);
            dp[len_1][len_2] = temp + 1;
        }
        else {
            int temp = longestHelp(s, dp, len_1 - 1, len_2);
            dp[len_1][len_2] = temp;
        }
        return dp[len_1][len_2];
    }

    public static void main(String[] args) {
        String s = "(()())";
        System.out.println(LongestValidParenthesesII.longestValidParentheses(s));
    }
}
