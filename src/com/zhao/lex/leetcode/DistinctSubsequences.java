package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/10/27.
 */
public class DistinctSubsequences {
//    public static int numDistinct(String s, String t) {
//
//        int[][] dp = new int[s.length() + 1][t.length() + 1];
//
//        return dp[s.length()][t.length()];
//    }
//
//    private static int help(int[][] dp, String s, String t, int row, int col) {
//        if(dp[row][col] != 0) return dp[row][col];
//        if(row == 0 && col == 0) {
//            dp[row][col] = 0;
//            return 0;
//        }else if(row == 0) {
//            dp[0][col] = help(dp, s, t, 0, col - 1);
//            return dp[0][col];
//        }else if(col == 0) {
//            dp[row][0] = help(dp, s, t, row - 1, 0);
//            return dp[row][0];
//        }
//        if(s.charAt(row - 1) == t.charAt(col - 1)) {
//            dp[row][col] = help(dp, s, t, row - 1, col - 1);
//        }
//        else {
//           int temp = help(dp, s, t, row - 1, col);
//           if(temp == 0) {
//               dp[row][col] = temp + 1;
//           }
//           else {
//               dp[row][col] = temp;
//           }
//        }
//        return dp[row][col];
//    }
    public static int numDistinct(String S, String T) {
        int[][] mem = new int[T.length()+1][S.length()+1];
        for(int j=0; j<=S.length(); j++) {
            mem[0][j] = 1;
        }


        for(int i=0; i<T.length(); i++) {
            for(int j=0; j<S.length(); j++) {
                if(T.charAt(i) == S.charAt(j)) {
                    mem[i+1][j+1] = mem[i][j] + mem[i+1][j];
                } else {
                    mem[i+1][j+1] = mem[i+1][j];
                }
            }
        }

        return mem[T.length()][S.length()];
    }
    public static void main(String[] args) {
        String s = "rabbbbbbbbbbbbbbit";
        String t = "rabbit";
        System.out.println(DistinctSubsequences.numDistinct(s, t));
    }
}
