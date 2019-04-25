package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2019/3/25.
 */
public class StringDemo {
    public String longestSubstring(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        int result = 0;
        String s = "";
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = 0;
                if(result < dp[i][j]) {
                    result = dp[i][j];
                    s = s1.substring(i - result, i);
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String s1 = "zhaoxudong";
        String s2 = "zhaoxdon";
        String s = "abcdefdcb";
        System.out.println(new StringDemo().longestSubstring(s1, s2));
        System.out.println(new StringDemo().longestSubsequence(s1, s2));
        System.out.println(new StringDemo().longestPalindromeSubstring(s));
        System.out.println(new StringDemo().longestPalindromeSubsequence(s));
    }

    public int longestSubsequence(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        int result = 0;
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

    public int longestPalindromeSubstring(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len + 1][len + 1];
        int result = 0;
        for(int i = 1; i <= len; i++) {
            for(int j = 1; j <= i; j++) {
                dp[j][i] = (s.charAt(i - 1) == s.charAt(j - 1)) && (i - j < 2 || dp[j + 1][i - 1]);
                if(dp[j][i])
                    result = Math.max(result, i - j + 1);
            }
        }
        return result;
    }

    public int longestPalindromeSubsequence(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++)
            dp[i][i] = 1;
        for(int i = 0; i < len; i++) {
            for(int j = i - 1; j >=0; j--) {
                if(s.charAt(i) == s.charAt(j))
                    dp[j][i] = dp[j + 1][i - 1] + 2;
                else
                    dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
            }
        }
        return dp[0][len - 1];
    }
}
