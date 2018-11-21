package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/11/6.
 */
public class NumbersAtMostGivenDigitSet {
    public int atMostNGivenDigitSet(String[] D, int N) {
        int length = D.length;
        int result = 0;
        int up = (int) Math.ceil(Math.log(N) / Math.log(10));
        int down = (int) Math.floor(Math.log(N) / Math.log(10));
        if(up == down) {
            for(int i = up; i >= 1; i--)
                result += Math.pow((double)length, i);
        }
        else {
            int[] dp = new int[up];
            for(int i = 0; i < up; i++) {
                int remainder  = N % (int)Math.pow(10.0, (double)up - i);
                dp[i] = remainder / (int)Math.pow(10.0, down - i);
            }
            for(int i = 0; i < down; i++) {
                for(int j = length - 1; j >= 0; j--) {
                    if(D[j].charAt(0) - 48 > dp[i])
                        continue;

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] digit = new String[]{"1", "4", "6", "7"};
        System.out.println(digit[3].charAt(0) - 48);
        new NumbersAtMostGivenDigitSet().atMostNGivenDigitSet(digit, 19941225);
    }
}
