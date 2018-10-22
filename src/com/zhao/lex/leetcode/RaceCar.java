package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/9/6.
 */
public class RaceCar {
    int[] dp = new int[10001];
    public int racecar(int t) {
        if (dp[t] > 0) return dp[t];
        int n = (int)(Math.log(t) / Math.log(2)) + 1;
        if (1 << n == t + 1) dp[t] = n;
        else {
            dp[t] = racecar((1 << n) - 1 - t) + n + 1;
            for (int m = 0; m < n - 1; ++m)
                dp[t] = Math.min(dp[t], racecar(t - (1 << (n - 1)) + (1 << m)) + n + m + 1);
        }
        return dp[t];
    }

    public static void main(String[] args) {
        System.out.println(new RaceCar().racecar(600));
        System.out.println((19941225 % 64) == (19941225 & 63));

    }
}
