package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/13.
 */
public class PalindromePartition {
    public static int minCutStep(String s) {
        if(s == null || s.length() == 1 || s.length() == 0) return 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] cut = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                dp[j][i] = (s.charAt(i) == s.charAt(j)) && ( i - j < 2 || dp[j + 1][i - 1]);
                if(dp[j][i])
                    min = (j == 0) ? 0 : Math.min(min, cut[j - 1] + 1);
            }
            cut[i] = min;
        }
        return cut[s.length() - 1];
    }

    public static void main(String[] args) {
        String s = "aabcccccccc";
        System.out.println(PalindromePartition.minCutStep(s));
    }
}
