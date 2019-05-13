package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/11/1.
 */
public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        if(s.equals("")) return "";
        int length = s.length();
        int result = 1;
        String substring = s.substring(0, result);
        boolean[][] dp = new boolean[length][length];
        for(int i = 0; i < length; i++) {
            for(int j = 0; j <= i; j++) {
                dp[j][i] = (s.charAt(j) == s.charAt(i)) && (i - j < 2 || dp[j + 1][i - 1]);
                if(dp[j][i] && result < i - j + 1){
                    result = i - j + 1;
                    substring = s.substring(j, i +  1);
                }
            }
        }
        return substring;
    }

    public static void main(String[] args) {
       String s = "abcxaab";
   //    System.out.println(new LongestPalindromeSubstring().longestPalindrome(s));
        System.out.println(new LongestPalindromeSubstring().longestPalindromeSubstring(s));
        System.out.println(new LongestPalindromeSubstring().longestPalindromeSubsequence(s));
    }

    public String longestPalindromeSubstring(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int result = 0;
        String sub = null;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j <= i; j++) {
                dp[j][i] = s.charAt(j) == s.charAt(i) && (i - j < 2 || dp[j + 1][i - 1]);
                if(dp[j][i] && result < i - j + 1) {
                    sub = s.substring(j, i + 1);
                    result = i - j + 1;
                }
            }
        }
        return sub;
    }

    public int longestPalindromeSubsequence(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(s.charAt(i) == s.charAt(j))
                    dp[j][i] = dp[j + 1][i - 1] + 2;
                else
                    dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
            }
        }
        return dp[0][len - 1];
    }
}
