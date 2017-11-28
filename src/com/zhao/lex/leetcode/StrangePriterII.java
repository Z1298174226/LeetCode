package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/27.
 */
public class StrangePriterII {
    public static int strangePrinter(String s) {
        char[] oldArray = s.toCharArray();
        char[] newArray = new char[oldArray.length];
        newArray[0] = oldArray[0];
        int n = 1;
        for(int i = 1; i < oldArray.length; i++) {
            if(oldArray[i] != oldArray[i - 1])
                newArray[n++] = oldArray[i];
        }
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++)
            dp[i][i] = 1;
      return dfs(dp, newArray, 0, n - 1);
    }

    private static int dfs(int[][] dp, char[] newArray, int left, int right) {
        if(left >= right) return 0;
        if(dp[left][right] > 0) return dp[left][right];
        int temp = dfs(dp, newArray, left, right - 1);
        if(newArray[left] == newArray[right]) {
            dp[left][right] = temp;

        }
        else {
            dp[left][right] = temp + 1;
            for(int k = left + 1; k < right; k++) {
                if(dp[left][k - 1] + dp[k][right] < dp[left][right]) {
                    dp[left][right] = temp;
                    return dp[left][right];
                }

            }
        }
        return dp[left][right];
    }

    public static void main(String[] args) {
        String s= "aaadefsgefsgdgaaazhaoxudongddddddddddddddddddddddddddddddddddddaaabbbbbccccbdegesgesgsdfsfdbaaaaaabbbcbccccczhhaoxudongccccbbbbbaaaaaaaaaaaaaa";
        System.out.println(StrangePriterII.strangePrinter(s));
    }
}
