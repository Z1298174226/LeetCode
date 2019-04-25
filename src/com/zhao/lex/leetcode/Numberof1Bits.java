package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2019/4/22.
 */
public class Numberof1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while(n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(new Numberof1Bits().hammingWeight(65535));
    }
}
