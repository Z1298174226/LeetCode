package com.zhao.lex.BinarySearchTree;

/**
 * Created by qtfs on 2019/5/27.
 */
public class UniqueBinaryTreeI {
    public int getUniqueBinaryTree(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= num; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[num];
    }

    public static void main(String[] args) {
        System.out.println(new UniqueBinaryTreeI().getUniqueBinaryTree(50));
    }
}
