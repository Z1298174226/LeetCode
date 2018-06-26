package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/6/10.
 */
public class Possion {
    private static int getPossionVariable(double lamda) {
        int x = 0;
        double y = Math.random(), cdf = getPossionProbability(x, lamda);
        while (cdf < y) {
            x++;
            cdf += getPossionProbability(x, lamda);
        }
        return x;
    }

    private static double getPossionProbability(int k, double lamda) {
        double c = Math.exp(-lamda), sum = 1;
        for (int i = 1; i <= k; i++) {
            sum *= lamda / i;
        }
        return sum * c;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++) {
            System.out.println(getPossionVariable(4) + 1);
        }
    }
}
