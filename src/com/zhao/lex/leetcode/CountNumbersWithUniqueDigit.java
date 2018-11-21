package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/11/8.
 */
public class CountNumbersWithUniqueDigit {
    int result = 0;
    public int countNumbersWithUniqueDigits(int n) {
        boolean[] used = new boolean[10];
        boolean noZero = false;
        dfs(n, n, used, noZero);
        return result;
    }

    private void dfs(int num, int n, boolean[] used, boolean noZero) {
        if(n == 0) result++;
        else {
            for(int i = 0; i < 10; i++) {
                if(used[i] && noZero) continue;
                used[i] = true;
                if(i != 0) noZero = true;
                dfs(num, n - 1, used, noZero);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CountNumbersWithUniqueDigit().countNumbersWithUniqueDigits(8));
        Integer a = 3;
        int aa = 3;
        System.out.println(a == aa);
    }
}
