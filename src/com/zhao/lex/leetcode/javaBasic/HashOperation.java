package com.zhao.lex.leetcode.javaBasic;

/**
 * Created by qtfs on 2018/9/2.
 */
public class HashOperation {
    public static void main(String[] args) {
        int N = 1987;
        int M = 16;
        System.out.println((N % M));
        System.out.println(N & (M - 1));
    }
}
