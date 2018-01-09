package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/22.
 */
public class CountDifferentPalindromicSubsequences {
    public static int countPalindromicSubsequences(String s) {
        int n = s.length();
        int count = 0;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            dp[i][i] = 1;
            count++;
            for(int j = i - 1; j >= 0; j--) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[j][i] = dp[j][i - 1] + 1;
//                    if(dp[j][i] > 1)
//                        count++;
                }
                else {
//                    if(dp[j + 1][i] >= 1)
//                        count++;
//                    if(dp[j][i - 1] >= 1)
//                        count++;
                }

            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "bccb";
        System.out.println(countPalindromicSubsequences(s));
    }
}
