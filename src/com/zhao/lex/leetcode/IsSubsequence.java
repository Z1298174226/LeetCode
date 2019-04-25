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

    public boolean isSubsequence_v2(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        int index1 = 0;
        int index2 = 0;
        while(index2 < length2) {
            if(s1.charAt(index1) == s2.charAt(index2)) {
                index1++;
                if(index1 == length1) return true;
            }
            index2++;
        }
        return false;
    }

    public boolean isSubsequence_v3(String s1, String s2) {
        int index = 0;
        int i = 0;
        while(i == s1.length()) {
            index = s2.indexOf(s1.charAt(i++), index);
            if (index == -1) return false;
            index++;
        }
        return true;
    }

    public boolean isSubsequence_v1(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = len2 - len1;
        boolean[][] dp = new boolean[len1 + 1][len3 + 1];
        for(int i = 0; i <= len3; i++)
            dp[0][i] = true;
        for(int i = 1; i <= len1; i++)
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s2.charAt(i - 1);
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len3; j++) {
                dp[i][j] = dp[i][j - 1] || (dp[i - 1][j] && s1.charAt(i - 1) == s2.charAt(i + j - 1));
            }
        }
        return dp[len1][len3];
    }

    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence_v1("zhaoxuong", "zhaoxudong"));
        System.out.println(new IsSubsequence().isSubsequence_v2("zhaoxung", "zhaoxudong"));
        System.out.println(new IsSubsequence().isSubsequence_v3("zhaoxung", "zhaoxudong"));
    }
}
