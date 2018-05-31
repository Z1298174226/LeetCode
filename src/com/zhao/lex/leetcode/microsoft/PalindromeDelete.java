package com.zhao.lex.leetcode.microsoft;

import java.util.Scanner;
/**
 * Created by qtfs on 2018/4/24.
 */
public class PalindromeDelete {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            int len = s.length();
            int[][] dp = new int[len + 1][len + 1];
            for (int i = 1; i <= len; i++)
                dp[i][i] = 1;
            for (int i = 2; i <= len; i++) {
                for (int l = 1; l <= len - i + 1; l++) {
                    int r = l + i - 1;
                    dp[l][r] += dp[l + 1][r];
                    dp[l][r] += dp[l][r - 1];
                    if (s.charAt(l - 1) == s.charAt(r - 1))
                        dp[l][r] += 1;
                    else
                        dp[l][r] -= dp[l + 1][r - 1];
                }
            }
            System.out.println(dp[1][len]);
        }
    }
}
