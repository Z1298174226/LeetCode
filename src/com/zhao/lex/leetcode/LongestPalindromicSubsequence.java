package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/22.
 */
public class LongestPalindromicSubsequence {

    public static int longestPalindromeSubseq(String s) {
        if(s == null) return 0;
        int[][] dp = new int[s.length()][s.length()];
        int result = 1;
        for(int i = 0; i < s.length(); i++)
            dp[i][i] = 1;
        for(int i = 1; i < s.length(); i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(s.charAt(i) == s.charAt(j))
                    dp[j][i] = dp[j + 1][i - 1] + 2;
                else
                    dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
                result = Math.max(result, dp[j][i]);
            }
        }
        return result;
    }

    /*
    public static int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int result = 1;
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(s.charAt(i) == s.charAt(j))
                    dp[j][i] = dp[j + 1][i - 1] + 2;
                else
                    dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
                result = Math.max(result, dp[j][i]);
            }
        }
        return result;
    }
    */
    public static void main(String[] args) {
        //String s = "euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew";
        String s = "abcda";
        System.out.println(longestPalindromeSubseq(s));
    }
}
