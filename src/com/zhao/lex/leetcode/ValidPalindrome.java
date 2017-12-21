package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/12/10.
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                dp[j][i] = (s.charAt(j) == s.charAt(i) ||Character.toLowerCase(s.charAt(j)) == s.charAt(i) || Character.toUpperCase(s.charAt(j)) == s.charAt(i) || !Character.isLetterOrDigit(s.charAt(i)) || !Character.isLetterOrDigit(s.charAt(j))) && (i - j < 2 || dp[j + 1][i - 1]);
            }
        }
        return dp[0][s.length() - 1];
    }
    public static void main(String[] args) {
        String s = "a,B..";
        System.out.println(isPalindrome(s));
    }
}
