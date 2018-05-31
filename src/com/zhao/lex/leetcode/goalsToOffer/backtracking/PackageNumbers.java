package com.zhao.lex.leetcode.goalsToOffer.backtracking;

/**
 * Created by qtfs on 2018/4/26.
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
//public class PackageNumbers {
//    public static void step(int length, int n, int[] array) {
//        if(length == 0 || n == 0) {
//            System.out.println(0);
//            return;
//        }
//        long[] dp = new long[n + 1];
//        Arrays.fill(dp, 1);
//        for(int i = 0; i < length; i++) {
//            for(int j = n; j >= array[i]; j--) {
//                dp[j] += dp[j - array[i]];
//            }
//        }
//        while(dp[n] == 0)
//            n--;
//        System.out.println(dp[n]);
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Random rand = new Random();
//        int length = scanner.nextInt();
//        int n = scanner.nextInt();
//        int[] array = new int[length];
//        for(int i = 0; i < length; i++)
//            array[i] = rand.nextInt(100000);
//        step(length, n, array);
//    }
//}

    import java.util.Scanner;


public class PackageNumbers {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            count = 0;
            int n = scanner.nextInt();
            int total = scanner.nextInt();
            int[] nums = new int[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
                sum += nums[i];
            }
            if (sum <= total) {
            System.out.println((int)Math.pow(2, n));
            } else {
                dfs(0, 0, n, nums, total);
                System.out.println(count + 1);
            }
        }
    }
    private static void dfs(long sum, int cur, int n, int[] nums, int total) {
       if(cur < n) {
           if (sum > total) return;
           dfs(sum, cur + 1, n, nums, total);
           if (sum + nums[cur] <= total) {
               dfs(sum + nums[cur], cur + 1, n, nums, total);
               count++;
           }
       }
    }

}