package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/16.
 */
public class StrangePriter {
    public static int strangePrinter(String s) {
        char[] sa = s.toCharArray();
        int n = 1;
        for(int i = 1; i < s.length(); i++) {
            if(sa[i] == sa[n - 1]) continue;
            sa[n++] = sa[i];
        }
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            dp[i][i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(sa[j] == sa[i]) {
                    dp[j][i] = dp[j][i - 1];
                    continue;
                }
                dp[j][i] = dp[j][i - 1] + 1;
                for(int k = j + 1; k < i; k++) {
                    if(sa[k] == sa[i]) {
                        if(dp[j][k - 1] + dp[k][i] < dp[j][i]) {
                            dp[j][i] = dp[j][i - 1];
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][n - 1];
    }


    public static int strangePrinter1(String s) {
        char[] cha = s.toCharArray();
        if(cha.length == 0) return 0;
        int n = 1;
        for(int i = 1; i < cha.length; i++) {
            if(cha[i] != cha[n - 1])
                cha[n++] = cha[i];
        }
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            dp[i][i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(cha[i] == cha[j])
                    dp[j][i] = dp[j][i - 1];
                else {
                    dp[j][i] = dp[j][i - 1] + 1;
                    for(int k = j; k < i; k++) {
                        if(dp[j][i] > dp[j][k] + dp[k + 1][i])
                            dp[j][i] = dp[j][k] + dp[k + 1][i];
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String s= "aaadefsgefsgdgaaazhaoxudongddddddddddddddddddddddddddddddddddddaaabbbbbccccbdegesgesgsdfsfdbaaaaaabbbcbccccczhhaoxudongccccbbbbbaaaaaaaaaaaaaa";
        System.out.println(StrangePriter.strangePrinter1(s));
    }
}
