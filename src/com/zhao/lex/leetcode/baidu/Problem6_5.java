package com.zhao.lex.leetcode.baidu;

import java.util.Random;
import java.util.Scanner;
/**
 * Created by qtfs on 2018/4/3.
 */
public class Problem6_5 {
    public static void step(int N) {
        Random rand = new Random();
       int[] number = new int[N];
        for(int i = 0; i < N; i++)
            number[i] = rand.nextInt(10000);
        int[] result = new int[N];
        int point = 0;
        boolean flag = false;
        result[point] = number[0];
        for(int i = 1; i < N; i++) {
            for(int j = 0; j <= point; j++) {
                if(number[i] == result[j]) {
                    flag = true;
                    break;
                }
            }
            if(!flag)
                result[++point] = number[i];
            flag = false;
        }
        for(int i = 0; i <= point; i++)
            System.out.print(result[i] + " ");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int N = scanner.nextInt();
            step(N);
        }
    }
}
