package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/11/24.
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int len1 = s.length();
        int len3 = t.length();
        int len2 = len3 - len1;
        if(len2 < 0) return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for(int i = 1; i <= len2; i++)
            dp[0][i] = true;
        for(int i = 1; i <= len1; i++)
            dp[i][0] = dp[i - 1][0] && s.charAt(i - 1) == t.charAt(i - 1);
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                dp[i][j] = dp[i - 1][j] && (s.charAt(i - 1) == t.charAt(i + j - 1)) || dp[i][j - 1];
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("abbd", "abdb"));
    }
}
