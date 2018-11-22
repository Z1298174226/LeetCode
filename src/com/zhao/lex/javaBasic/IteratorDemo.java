package com.zhao.lex.javaBasic;

/**
 * Created by qtfs on 2018/4/4.
 */
/*
题目一：
题意：有一组数组，每次遍历一次数组，遇到一个比它左边的数大的数就标记，然后遍历一遍之后，删除那些标记的值。
然后不断重复，问需要多少次能结束这样的操作，也就是是一个非递增数组？。
example：
input：〔3,6,9,8〕
output：2
 */


import java.time.Clock;
import java.util.Random;
import java.util.Scanner;
public class IteratorDemo {
    public static void step(int[] nums) {
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());
        long starttime = System.currentTimeMillis();
        int N = nums.length;
        boolean[] flags = new boolean[N];
        boolean marked = true;
        int count = 0;
        while(marked) {
            marked = false;
            int point = 0;
            for (int i = 1; i < N; i++) {
                if(!flags[i]) {
                    if(nums[i] >= nums[point]) {
                        flags[i] = true;
                        marked = true;
                    }
                    point = i;
                }
            }
            if(marked)
                count++;
        }
        System.out.println(count);
        for(int i = 0; i < N; i++) {
            if(!flags[i])
                System.out.print(nums[i] + " ");
        }
        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("Cost time : " + (endTime - starttime));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        while(true) {
            int N = scanner.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = rand.nextInt(10000);
            }
            step(nums);
        }
    }
}
