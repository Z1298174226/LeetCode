package com.zhao.lex.wangyi;

/**
 * Created by qtfs on 2018/4/26.
 */
import java.util.Scanner;
public class StringFragment {
    public static double stringFragment(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int[] cut = new int[length];
        int[] lengths = new int[length];
        int index = 0;
        int sumLength = 0;
        for(int i = 0; i < length; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                dp[j][i] = (s.charAt(j) == s.charAt(i)) && (i - j < 2 || (/* s.charAt(j) == s.charAt(j + 1) && */dp[j + 1][i - 1] ));
                if(dp[j][i])
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
            }
            cut[i] = min;
        }
        return cut[length - 1] + 1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        System.out.println(stringFragment(S));
    }
}
