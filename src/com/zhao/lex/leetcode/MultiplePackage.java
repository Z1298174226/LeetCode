package com.zhao.lex.leetcode;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by qtfs on 2017/9/26.
 */
public class MultiplePackage {
//    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//        System.out.println(MultiplePackage.multiplePackage(nums, 5));
//    }
//
//    private static int multiplePackage(int[] nums, int target) {
//        int count = 0;
//        int[] numbers = new int[nums.length];
//        for(int i = 0; i < nums.length; i++) {
//            numbers[i] = target / nums[i];
//        }
//        int[][] F = new int[nums.length + 1][target + 1];
//        for(int i = 0; i < F.length; i++) Arrays.fill(F[i], -1);
//        F[0][0] = 0;
//        for(int i = 1; i < nums.length; i++) {
//            for(int j = 0; j <= target; j++) {
//                if(F[i-1][j] >= 0)  F[i][j] = numbers[i];
//                else F[i][j] = -1;
//            }
//            for(int j = 0; j < target - nums[i]; j++) {
//                if(F[i][j] > 0)
//                    F[i][j + nums[i]] = Math.max(F[i][j + nums[i]], F[i][j] - 1);
//            }
//        }
//        for(int i = 1; i < nums.length; i++) {
//            if(F[i][target] >= 0) count++;
//        }
//        return count;
//    }
    public CountDownLatch countDownLatch= new CountDownLatch(1);
    public CyclicBarrier cyclicBarrier = new CyclicBarrier(1);
    private int multiplePackage(int N, int V, int[] nums, int[] volumes, int[] values) {
        long start = System.currentTimeMillis();
        int[] dp = new int[V + 1];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < nums[i]; j++) {
                for(int k = V; k >= volumes[i]; k--) {
                    dp[k] = Math.max(dp[k], dp[k - volumes[i]] + values[i]);
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return dp[V];
    }

    public  int multiplePackageOpt(int N, int V, int[] nums, int[] volumes, int[] values) {
        long start = System.currentTimeMillis();
        int[] dp = new int[V + 1];
        int fac = 0;
        int opt = 0;
        for(int i = 0; i < N; i++) {
            opt = (int)Math.pow(nums[i] + 1, 0.5);
            for(int j = 0; j <= opt; j++) {
                fac = (int) ((j != opt) ? Math.pow(2, j) : nums[i] + 1 - Math.pow(2, j));
                for(int k = V; k >= fac * volumes[i]; k--) {
                    dp[k] = Math.max(dp[k], dp[k - fac * volumes[i]] + fac * values[i]);
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return dp[V];
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int N = 5000;
        int V = 100000;
        int[] nums = new int[N];
        int[] volumes = new int[N];
        int[] values = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = rand.nextInt(20) +  1;
            volumes[i] = rand.nextInt(5) + 1;
            values[i] = rand.nextInt(5) + 1;
        }
        MultiplePackage mul = new MultiplePackage();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mul.countDownLatch.await();
                    System.out.println(mul.multiplePackage(N, V, nums, volumes, values));
                }catch(InterruptedException ex) {

                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mul.countDownLatch.await();
                    System.out.println(mul.multiplePackageOpt(N, V, nums, volumes, values));
                }catch(InterruptedException ex) {

                }
            }
        });
        Callable<Integer> callable = new Callable<Integer>(){
          @Override
            public Integer call() {
              return mul.multiplePackageOpt(N, V, nums, volumes, values);
          }
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future =  executorService.submit(callable);
        Thread thread3 = new Thread(new Runnable() {
           @Override
            public void run() {
               try{
                   mul.countDownLatch.await();
                   System.out.println(future.get());
               }catch(InterruptedException ex) {

               }catch(ExecutionException ex) {

               }
           }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        mul.countDownLatch.countDown();
    }
}
