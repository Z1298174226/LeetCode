package com.zhao.lex.leetcode.baidu;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/**
 * Created by qtfs on 2018/4/3.
 */
public class Problem6_21 {
    public static void step(int numbers, int slots) {
        int[] arrays = new int[slots];
        float[] result = new float[numbers];
        int[] nums = new int[slots + 1];
        int max = Integer.MIN_VALUE;
        Arrays.fill(result, slots / 2);
        Random rand = new Random();
        for(int i = 0; i < numbers; i++) {
            for(int j = 0; j < slots; j++) {
                arrays[j] = rand.nextInt(2);
                if(arrays[j] == 0)
                    result[i] -= 0.5;
                else
                    result[i] += 0.5;
            }
        }
        for(int i = 0; i < numbers; i++) {
            nums[(int) result[i]]++;
            max = Math.max(max, nums[(int) result[i]]);
        }

        for(int i = max; i > 0; i--) {
            for(int j = 0; j < slots + 1; j++) {
                if(nums[j] == i) {
                    System.out.print((j != slots) ?  ("|" + "o") : ("|" + "o" + "|"));
                    nums[j]--;
                }
                else
                    System.out.print((j != slots) ?  ("|" + " ") : ("| " + "|"));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int number = scanner.nextInt();
            int slots = scanner.nextInt();
            step(number, slots);
        }
    }
}
