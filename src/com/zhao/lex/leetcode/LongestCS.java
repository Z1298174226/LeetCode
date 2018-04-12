package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/4/11.
 */
public class LongestCS {
/*
    public static void step(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if(length1 == 0 || length2 == 0) return;
        int start1 = -1;
        int longest = 0;
        int comparisons = 0;
        for(int i = 0; i < length1; i++) {
            int m = i;
            int n = 0;
            int length = 0;
            while(m < length1 && n < length2) {
                ++comparisons;
                if(s1.charAt(m) != s2.charAt(n)) {
                    length = 0;
                }
                else {
                    ++length;
                    if(longest < length) {
                        longest = length;
                        start1 = m - longest + 1;
                    }
                }
                ++m;
                ++n;
            }
        }
        System.out.println(start1);
   //     System.out.println(longest + "=>" + s1.substring(start1, start1 + longest));
    }
    */
//public static void main(String[] args) {
//    // TODO Auto-generated method stub
//    String A = "cbb";//ABCD
//    String B = "acabaab";//CBCE
//    System.out.println(largest(A, B));
//}

    public static void largest(String A, String B) {
        int n = A.length();
        int m = B.length();
        int num = 0;
        int end = 0;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            char c1 = A.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char c2 = B.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {

                    dp[i][j] = 0;
                }
                if(num < dp[i][j]) {
                    num = dp[i][j];
                    end = i;
                }
            }
        }
        System.out.println(num + "=>" + A.substring(end - num, end));
    }///largest
    public static void main(String[] args) {
        String s1 = "zhaoxudong";
        String s2 = "yangxudhen";
        largest(s1, s2);
    }
}
