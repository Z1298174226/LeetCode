package com.zhao.lex.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by qtfs on 2019/4/29.
 */
public class JumpDP {
    public int shortestJump(int[] arr) {
        int len = arr.length;
        int[] dp = new int[len + 1];
        Arrays.fill(dp, 1000000);
        dp[1] = 0;
        for(int i = 1; i <= arr.length; i++) {
            for(int k = 1; k <= arr[i - 1]; k++) {
                if (i + k <= arr.length)
                    dp[i + k] = Math.min(dp[i + k], dp[i] + 1);

            }
        }
        return dp[len] > 100000 ? -1 : dp[len];
    }

    public int shortestJumpUpdate(int[] arr) {
        //跳数
        int jump = 0;
        //当前跳数能到的最远距离
        int cur = 0;
        //再跳一步能到的最远距离
        int next = 0;
        for(int i = 0; i < arr.length; i++) {
            if(cur < i) {
                jump++;
                cur = next;
            }
            next = Math.max(next, i + arr[i]);
        }
        return jump;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[1001001];
        for(int i = 0; i < 1001001; i++)
            arr[i] = rand.nextInt(15) + 1;
        //int[] arr = new int[]{1, 3, 7, 1, 8, 0, 6, 5, 4, 6, 8, 1, 3, 4, 3, 3, 1, 1, 6, 1, 1, 1, 1, 1, 1, 5, 3, 2};
        System.out.println(new JumpDP().shortestJump(arr));
        System.out.println(new JumpDP().shortestJumpUpdate(arr));
    }
}
