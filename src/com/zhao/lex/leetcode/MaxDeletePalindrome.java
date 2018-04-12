package com.zhao.lex.leetcode;

import java.util.Scanner;
/*
 Created by qtfs on 2018/4/9.
 */
public class MaxDeletePalindrome {
    public static int deletePalindrome(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for(int i = 0; i < length; i++) {
            dp[i][i] = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(s.charAt(j) == s.charAt(i)) {
                    if(i - j == 1) {
                        dp[j][i] = dp[j + 1][i - 1] + 1;
                    }else {
                        if(s.charAt(i) == s.charAt(i - 1))
                            dp[j][i] = dp[j + 1][i - 1] + 2;
                        else
                            dp[j][i] = dp[j + 1][i - 1] + 4;
                    }
                }
                else {
                    dp[j][i] = Math.max(dp[j][i - 1], dp[j + 1][i]) + ((i - j) == 1 ? 2 : 1);
                }
            }
        }
        return dp[0][length - 1] + 1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println(deletePalindrome(scanner.next()));
        }
    }

}
