package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/4/11.
 */
public class LongestCS {


    public static int longestSameSubSequence(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for(int i = 1; i <= length1; i++) {
            for(int j = 1; j <= length2; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[length1][length2];
    }

    public static int longestSameSubString(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        int len = 0;
        int end = 0;
        for(int i = 1; i < length1; i++) {
            for(int j = 1; j< length2; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = 0;
                if(len < dp[i][j]) {
                    len = dp[i][j];
                    end = i;
                }
            }
        }
        System.out.println(len + " => " + s1.substring(end - len, end));
        return dp[length1][length2];
    }

    public int longestSameSubstring(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        int len = 0;
        int end = 0;
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = 0;
                if(len < dp[i][j]) {
                    len = dp[i][j];
                    end = i;
                }
            }
        }
        System.out.println(s1.substring(end - len, end));
        return len;
    }

    public static void main(String[] args) {
        String s1 = "zhaoxudong";
        String s2 = "yangxudhe";
        System.out.println(longestSameSubSequence(s1, s2));
        longestSameSubString(s1, s2);
  //      System.out.println(new LongestCS().longestSameSubstring(s1, s2));
    }
}
