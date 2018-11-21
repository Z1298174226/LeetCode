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
       String s = "abdab";
       System.out.println(new LongestPalindromeSubstring().longestPalindrome(s));
    }
}
